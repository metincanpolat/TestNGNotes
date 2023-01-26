package PROJELER.Proje_01;

import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Proje01Driver {

    public static WebDriver driver;
    public static WebDriverWait waitAWhile;

    @BeforeClass
    public void baslangicIslemleri(){


        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE); // Sadece errorları göster
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // Chrome servisi sessiz modda çalışır.
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver(); // web sayfasını kontrol eden görevli

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

    void loginTest(){
        driver.get("https://demo.nopcommerce.com");
        System.out.println("login test");

//        WebElement inputEmail=driver.findElement(By.id("input-email"));
//        inputEmail.sendKeys("metcan123@hotmail.com");
//
//        WebElement password=driver.findElement(By.id("input-password"));
//        password.sendKeys("123456");

//        WebElement loginBtn=driver.findElement(By.cssSelector("input[type='submit']"));
//        loginBtn.click();
//
//        Assert.assertEquals(driver.getTitle(),"My Account","Login başarısız");

    }


}
