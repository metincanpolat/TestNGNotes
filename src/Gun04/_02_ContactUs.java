package Gun04;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02_ContactUs extends BaseDriver {
    /*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */
    @Test
    @Parameters("mesaj")
    void ContactUs(String gelenMesaj){

        driver.findElement(By.linkText("Contact Us")).click();

        driver.findElement(By.id("input-enquiry")).sendKeys(gelenMesaj);

        driver.findElement(By.cssSelector("[value='Submit']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));



    }





}
