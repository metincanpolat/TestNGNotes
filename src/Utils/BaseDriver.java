package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait waitAWhile;

    @BeforeClass(groups = "SmokeTest")
    public void baslangicIslemleri(){
        // ilk adımda çalışan kod kısmı

        Logger logger= Logger.getLogger(""); // Sisteme ait bütün log ları üreten objeye/servise ulaştım.
        logger.setLevel(Level.SEVERE); // Sadece errorları göster
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // Chrome servisi sessiz modda çalışır.
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver(); // web sayfasını kontrol eden görevli

        driver.manage().window().maximize();  // Ekranı max yapıyor. minimize simge durumuna düşüüyor
        driver.manage().deleteAllCookies();  // sitenin senin bilgisayarında yaptığı ayarlar siliniyor, sayfa başlangıç ayarlarına dönüyor
        // Bazen siteler bizim bot olduğumuzu düşünüp çerezlere imza bırakabiliyor.
        // bu noktada siteye her girişimizde çerezleri sıfırlarsak bu durumu önleyebiliyoruz.
        // bu bazen her komutta bir yapmak gerekebiliyor.

        Duration dr=Duration.ofSeconds(30); // zaman aralığı
        //driver.manage().timeouts().pageLoadTimeout(dr); // Sadece tüm sayfanın kodlarının bilgisyarınıza inmesi süresiyle ilgili
        //bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.: 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
        // eğer 2 sn yüklerse 30 sn. beklemez.

        driver.manage().timeouts().implicitlyWait(dr); // Bütün weblementlerin element bazında, elemente özel işlem yapılmadan önce
        // hazır hale gelmesi için verilen mühlet yani süre. O element hazır olana kadar. Mesela tıklayacağı button un hazır olması için verilen
        // süre kadar bekliyor.

        waitAWhile=new WebDriverWait(driver,Duration.ofSeconds(30));

        loginTest();
    }

    @AfterClass(groups = "SmokeTest",enabled = false)
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
