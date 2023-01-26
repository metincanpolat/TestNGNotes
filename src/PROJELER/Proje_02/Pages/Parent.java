package PROJELER.Proje_02.Pages;

import PROJELER.Proje_02.Proje02DriverPA;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Parent extends Proje02DriverPA {

    public void sendKeysFunction(WebElement element, String value)
    {
        waitAWhile.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear(); // kutuyu temizle
        element.sendKeys(value); // değeri gönder

    }

    public void clickFunction(WebElement element)
    {
        waitAWhile.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);  // elemente kadar scroll yap (javascriptexecuter)
        element.click();           //        click
    }


    public void scrollToElement(WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void textCheckAssert(WebElement element, String value)
    {
        Assert.assertTrue(element.getText().contains(value));
    }
}
