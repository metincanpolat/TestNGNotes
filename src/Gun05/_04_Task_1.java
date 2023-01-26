package Gun05;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _04_Task_1 extends BaseDriver {
    /**
     * Daha önceki derslerde yaptğımı Search fonksiyonunu
     * mac,ipod ve samsung için Dataprovider ile yapınız.
     */

    @Test(dataProvider = "getData")
    void searchTest(String aranacakKelime){


        WebElement searchInput=driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(aranacakKelime);

        WebElement searchButton =
                driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> captions= driver.findElements(By.cssSelector("div[class='caption']>h4"));

        for(WebElement e: captions)
            Assert.assertTrue(e.getText().toLowerCase().contains(aranacakKelime));
    }

    @DataProvider
    Object[] getData(){
        Object[] data={"mac","ipod","samsung"};

        return data;
    }


}
