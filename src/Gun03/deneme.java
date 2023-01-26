package Gun03;

import Utils.BaseDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class deneme extends BaseDriver {


    @Test(priority = 1)
    void addAddress()
    {
        WebElement addressBook=driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement newAddress=driver.findElement(By.linkText("New Address"));
        newAddress.click();

        WebElement firsName=driver.findElement(By.id("input-firstname"));
        firsName.sendKeys("Ahmet");

        WebElement lastname=driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Demir");

        WebElement company=driver.findElement(By.id("input-company"));
        company.sendKeys("Techno Study");

        WebElement address1=driver.findElement(By.id("input-address-1"));
        address1.sendKeys("21a London Road");

        WebElement address2=driver.findElement(By.id("input-address-2"));
        address2.sendKeys("RG2 5BJ");

        WebElement city=driver.findElement(By.id("input-city"));
        city.sendKeys("Reading");

        WebElement postCode=driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("12345");

        WebElement country=driver.findElement(By.id("input-country"));
        Select countrySelect= new Select(country);
        countrySelect.selectByVisibleText("Turkey");

        WebElement State=driver.findElement(By.id("input-zone"));
        Select StateSelect= new Select(State);
        StateSelect.selectByVisibleText("Adana");

        WebElement defadres=driver.findElement(By.cssSelector("label [name='default'][value='1']"));
        defadres.click();

        WebElement ctn=driver.findElement(By.cssSelector("input[type='submit']"));
        ctn.click();

        Tools.successMessageValidation();
    }

    @Test(priority = 2)
    void editAddress()
    {
        WebElement addressBook=driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll=driver.findElements(By.linkText("Edit"));
        WebElement sonEdit= editAll.get(editAll.size()-1); // son edit

        WebElement firsName=driver.findElement(By.id("input-firstname"));
        firsName.sendKeys("Mehmet");

        WebElement lastname=driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Yılmaz");

        WebElement ctn=driver.findElement(By.cssSelector("input[type='submit']"));
        ctn.click();

        Tools.successMessageValidation();
    }

    @Test(priority = 3)
    void deleteAddress()
    {
        WebElement addressBook=driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> deleteAll=driver.findElements(By.linkText("Delete"));
        WebElement silinebilirAdres= deleteAll.get(deleteAll.size()-2); // son edit

        silinebilirAdres.click();
        Tools.successMessageValidation();
    }



}
