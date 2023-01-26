package Gun05;

import Utils.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _05_Task_2 extends BaseDriverParameter {
    /**
     * Bir önceki task da yapılan testi PARAMETERDRIVER ile yapınız
     * sonrasında fakrlı tarayıcılar ile çalıştırınız.
     * sonrasında paralel çalıştırınız.
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
