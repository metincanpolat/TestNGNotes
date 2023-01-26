package Gun04;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class _03_SearchFunctionality extends BaseDriver {
    /*
       Senaryo ;
       1- Siteyi açınız.
       2- mac kelimeini göndererek aratınız.
       3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
       4- aynı işlemi samsung için de yapınız
     */

    @Parameters("aranacakKelime")
    @Test
    void searchTest(String aranacakKelime){


        new Actions(driver).sendKeys(driver.findElement(By.name("search")),aranacakKelime).sendKeys(Keys.ENTER).perform();





        List<WebElement> captions=driver.findElements(By.cssSelector("div[class='caption']>h4"));



        for (WebElement e : captions)
            Assert.assertTrue(e.getText().toLowerCase().contains(aranacakKelime));

    }





}
