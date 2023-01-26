package Gun02;

import Utils.BaseDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _01_EditAccount extends BaseDriver {
    /*
  Senaryo
  1- Siteyi açınız.
  2- Edit Account sayfasına ulaşınız.
  3- Ad ve soyadı değiştirip tekrar kaydedidiniz.
 */

    @Test

    void editAccount(){

        editAccountTest("met2","can2");
        Tools.Wait(2);
        editAccountTest("met","can");

    }

    void editAccountTest(String ad,String soyad){
        WebElement editAccountBut = driver.findElement(By.linkText("Edit Account"));
        editAccountBut.click();
        WebElement name=driver.findElement(By.id("input-firstname"));
        name.clear();
        name.sendKeys(ad);


        WebElement surName=driver.findElement(By.id("input-lastname"));
        surName.clear();
        surName.sendKeys(soyad);

        WebElement continueBut=driver.findElement(By.cssSelector("[value='Continue']"));
        continueBut.click();

        Tools.successMessageValidation();


    }

}
