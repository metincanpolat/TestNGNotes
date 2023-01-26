package Gun01;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Ornek extends BaseDriver {

    @Test
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

        //title, dom içersinde <head> altında <title>......</title> kısmında yer alıyor


    }
}
