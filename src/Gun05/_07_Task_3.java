package Gun05;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _07_Task_3 extends BaseDriver {

    /*
   Senaryo
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Cikan urun lerde (bütün ürünlerde indirim var mı eski fiyat yeni fiyattan büyük mü)
   4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu andaki fiyattan
      yüksek olduğunu doğrulayınız.
*/

    @Test
    void priceCheck(){

        driver.findElement(By.linkText("Specials")).click();



        List<WebElement> pricesElmnt=driver.findElements(By.className("price"));
        List<WebElement> pricesOld=driver.findElements(By.cssSelector("[class='price']>[class='price-old']")); // old fiyatlar

        Assert.assertEquals(pricesOld.size(), pricesElmnt.size(),"Tüm ürünler indirimde değil");

        for (WebElement e : pricesElmnt) {
            String[] prices = e.getText().split(" ");
            double price = (Double.parseDouble(prices[1].replaceAll("\\$", "").replaceAll("[A-Z][a-z]", ""))) - (Double.parseDouble(prices[0].replaceAll("\\$", "").replaceAll("[A-Z]", "")));
            System.out.println("fiyat farkı : " + price);
            Assert.assertTrue(price > 0, "Fiyat daha ucuz değil");
        }

    }

}
