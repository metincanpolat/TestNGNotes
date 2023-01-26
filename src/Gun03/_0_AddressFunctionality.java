package Gun03;

import Utils.BaseDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class _0_AddressFunctionality extends BaseDriver {

    /*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son adresi siliniz.
 */

    @Test
    void addAdress(){

        WebElement adressBook= waitAWhile.until(ExpectedConditions.elementToBeClickable(By.linkText("Address Book")));
        adressBook.click();
        WebElement newAddress= driver.findElement(By.linkText("New Address"));
        newAddress.click();
        WebElement firstName=waitAWhile.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
        firstName.sendKeys("Met");
        WebElement lastName=driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("can");
        WebElement address=driver.findElement(By.id("input-address-1"));
        address.sendKeys("Dalaman");
        WebElement city=driver.findElement(By.id("input-city"));
        city.sendKeys("Mugla");
        WebElement postCode=driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("Mugla");

        WebElement country=driver.findElement(By.id("input-country"));
        Select countrySelect= new Select(country);
        countrySelect.selectByVisibleText("Turkey");

        WebElement option=driver.findElement(By.cssSelector("select[id='input-zone']>option"));
        waitAWhile.until(ExpectedConditions.stalenessOf(option)); // stale element durumu düzelene kadar bekle.

        WebElement State=driver.findElement(By.id("input-zone"));
        Select StateSelect= new Select(State);
        StateSelect.selectByVisibleText("Adana"); // selectByVisibleText,selectValue implicitly wait ile çalıştı
        // selectByIndex imlicitlyWait ile çalışmıyor.
        //StateSelect.getOptions(); // liste halinde o select menuyu veriyor.

        WebElement defaultAdd= driver.findElement(By.cssSelector("[class='radio-inline']>[value='1']"));
        defaultAdd.click();
        WebElement continueBtn= driver.findElement(By.cssSelector("[value='Continue']"));
        continueBtn.click();

        Tools.successMessageValidation();

    }
    @Test(dependsOnMethods = {"addAdress"})
    void editAddress(){
        WebElement adressBook= waitAWhile.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Address Book")));
        adressBook.click();

        List<WebElement> editList=driver.findElements(By.linkText("Edit"));
        WebElement lastAddressEdit=editList.get(editList.size()-1); // sondaki edit
        lastAddressEdit.click();

        //Tools.Wait(2);
        WebElement firstName=waitAWhile.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
        firstName.clear();
        firstName.sendKeys("Can");
        //Tools.Wait(2);

        new Actions(driver).sendKeys(Keys.TAB).sendKeys("Met").perform();
        //Tools.Wait(2);

        WebElement continueBtn= driver.findElement(By.cssSelector("[value='Continue']"));
        continueBtn.click();

        //WebElement option=driver.findElement(By.cssSelector("select[id='input-zone']>option"));

        //waitAWhile.until(ExpectedConditions.stalenessOf(option));

        Tools.successMessageValidation();

    }
    @Test(dependsOnMethods = {"editAddress"})
    void deleteAdress(){
        WebElement adressBook= driver.findElement(By.linkText("Address Book"));
        adressBook.click();

        List<WebElement> editList=driver.findElements(By.linkText("Delete"));
        WebElement silinecekAddress=editList.get(editList.size()-2);
        silinecekAddress.click();

        Tools.successMessageValidation();



    }

}
