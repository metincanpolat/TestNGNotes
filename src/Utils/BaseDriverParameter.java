package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {

    public WebDriver driver;
    public static WebDriverWait waitAWhile;

    @BeforeClass
    @Parameters("browser")
    public void baslangicIslemleri(String browser){


        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();}
        else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            System.out.println("Firefox was started successfully.");
            driver = new FirefoxDriver();}

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Duration dr=Duration.ofSeconds(30);

        driver.manage().timeouts().implicitlyWait(dr);

        waitAWhile=new WebDriverWait(driver,Duration.ofSeconds(30));

        loginTest();
    }

    @AfterClass
    public void bitisIslemleri(){
        Tools.Wait(3);
        driver.quit();
    }

//    public void driverWaitQuit(int second){
//        Tools.Wait(second);
//        driver.quit();
//    }

    void loginTest(){
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        System.out.println("login test");

        WebElement inputEmail=driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("metcan123@hotmail.com");

        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("123456");

        WebElement loginBtn=driver.findElement(By.cssSelector("input[type='submit']"));
        loginBtn.click();

        Assert.assertEquals(driver.getTitle(),"My Account","Login başarısız");

    }
}
