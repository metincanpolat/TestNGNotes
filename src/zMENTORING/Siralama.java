package zMENTORING;
import Utils.BaseDriver;
import Utils.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Siralama extends BaseDriver{

    public static WebDriver driver;

    @BeforeTest
    public void startTest(){
        Logger logger= Logger.getLogger(""); // sisteme ait bütün logları üreten objeye/servise ulaştım ""
        logger.setLevel(Level.SEVERE); // Sadece errorları göster

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");  // ChromeServici sessiz modda çalıştır
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        System.out.println("Test ten once calisti");
    }

    @BeforeClass(alwaysRun = true)
    public void startClass(){
        System.out.println("Class dan once calisti");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        System.out.println("Method dan once calisti");
    }

    @Test
    public void startTest1(){
        System.out.println("dependent method");
    }

    @Test(groups = "deneme", dependsOnMethods = {"startTest1"})
    public void normalTest(){
        System.out.println("Test metodu");
    }

    @AfterTest(alwaysRun = true)
    public void closeTest(){
        System.out.println("bitiş işlemleri");
        Tools.Wait(3);
        driver.quit();
    }


}