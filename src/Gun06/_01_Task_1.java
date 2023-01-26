package Gun06;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Task_1 extends BaseDriver {

    /*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/
    @Test
    void cartCheck(){
        new Actions(driver).sendKeys(driver.findElement(By.name("search")),"ipod").sendKeys(Keys.ENTER).perform();

        driver.findElement(By.xpath("//h4/child::a[contains(text(),iPod)]")).click();
        driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
        driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();
        driver.findElement(By.linkText("Checkout")).click();
        driver.findElement(By.cssSelector("[value='Continue']")).click();
        waitAWhile.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("button-shipping-address")))).click();
        waitAWhile.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("button-shipping-method")))).click();
        waitAWhile.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[name='agree']")))).click();
        driver.findElement(By.id("button-payment-method")).click();
        driver.findElement(By.id("button-confirm")).click();

        waitAWhile.until(ExpectedConditions.urlContains("success"));

        //System.out.println(driver.findElement(By.xpath("//div[@id='content']/child::h1")).getText());

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/child::h1")).getText().contains("placed!"),"Onay mesajı görülmedi");









    }
}
