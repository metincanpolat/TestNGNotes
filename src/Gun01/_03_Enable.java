package Gun01;

import Utils.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _03_Enable {

    @Test
    void test1()
    {
        System.out.println("test1");
    }
    @Test (enabled = false) // bu şekilde testi durduruyoruz.
    void test2()
    {
        System.out.println("test2");
    }
    @Test
    void test3()
    {
        System.out.println("test3");
    }


}
