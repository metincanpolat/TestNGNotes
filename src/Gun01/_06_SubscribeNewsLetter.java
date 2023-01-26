package Gun01;

import Utils.BaseDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _06_SubscribeNewsLetter extends BaseDriver {
    ///*
    //  Senaryo
    //  1- Siteyi açınız.
    //  2- Newsletter  Subscribe işlemini abone lunuz(YES)
    // */
    By link=By.linkText("Newsletter");
    By radioYess=By.cssSelector("[type='radio'][value='1']");
    By radioNoo=By.cssSelector("[type='radio'][value='0']");
    By continueButt=By.cssSelector("[value='Continue']");



    @Test (priority = 1)
    void SubscribeTestYes(){

        WebElement newsletterLink=driver.findElement(link);
        newsletterLink.click();

        WebElement radioYes= driver.findElement(radioYess);
        radioYes.click();

        WebElement continueBut= driver.findElement(continueButt);
        continueBut.click();

        Tools.successMessageValidation();


    }
    @Test (priority = 2)
    void SubscribeTestNo(){

        WebElement newsletterLink=driver.findElement(link);
        newsletterLink.click();

        WebElement radioNo= driver.findElement(radioNoo);
        radioNo.click();

        WebElement continueBut= driver.findElement(continueButt);
        continueBut.click();

        Tools.successMessageValidation();
    }
    @Test (priority = 3)
    void SubscribeFunctionForBoth(){
        WebElement newsletterLink=driver.findElement(link);
        newsletterLink.click();

        WebElement radioYes= driver.findElement(radioYess);
        WebElement radioNo= driver.findElement(radioNoo);

        if (radioYes.isSelected())
            radioNo.click();
        else radioYes.click();

        WebElement continueBut= driver.findElement(continueButt);
        continueBut.click();

        Tools.successMessageValidation();

    }

}
