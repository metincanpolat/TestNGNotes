package PROJELER.Proje_01;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Proje01_nopcommerce extends Proje01Driver {

    @Test(priority = 1)
    void RegistratonsTest() {

        PlaceOrderElements elements = new PlaceOrderElements();

        elements.registerLink.click();
        elements.genderMale.click();
        elements.firstName.sendKeys("Met");
        elements.lastName.sendKeys("Can");
        elements.dateOfBirthDay.sendKeys("25");
        elements.dateOfBirthMonth.sendKeys("March");
        elements.dateOfBirthYear.sendKeys("1984");
        elements.email.sendKeys("abc@technostudy.com");
        elements.password.sendKeys("123456");
        elements.confirmPassword.sendKeys("123456");
        elements.registerBtn.click();

        Assert.assertTrue(elements.resulText.getText().contains("completed"), "Onay mesajı görülmedi");

        elements.logOut.click();
    }

    @Test(priority = 2)
    void LoginTest() {
        PlaceOrderElements elements = new PlaceOrderElements();

        elements.login.click();
        elements.email.sendKeys("abc@technostudy.com");
        elements.password.sendKeys("123456");
        elements.logInBtn.click();

        Assert.assertTrue(elements.logOut.getText().contains("Log out"), "Log In yapılamadı");

        elements.logOut.click();

    }

    @Test(priority = 3, dataProvider = "getData")
    void DataProviderLogin(String email, String password, String check) {

        PlaceOrderElements elements = new PlaceOrderElements();

        elements.login.click();
        elements.email.sendKeys(email);
        elements.password.sendKeys(password);
        elements.logInBtn.click();
        if (check.equalsIgnoreCase("wrong")) {
            Assert.assertTrue(elements.resulTextWrong.getText().toLowerCase().contains("unsuccessful"));
        } else {Assert.assertEquals(elements.logOut.getText().toLowerCase(), "log out");
        elements.logOut.click();}

    }

    @DataProvider
    Object[][] getData() {

        Object[][] logins = {
                {"wrongEmail@technoStudy.com", "1225215", "wrong"},
                {"abc@technostudy.com", "123456", "my account"}
        };
        return logins;
    }

    @Test(priority = 4)
    void TabMenuTest() {
        PlaceOrderElements elements = new PlaceOrderElements();

        for (int i = 0; i < elements.tabMenuListStr.size(); i++)
            Assert.assertEquals(elements.tabMenu.get(i).getText(), elements.tabMenuListStr.get(i));
    }

    @Test(priority = 5)
    void OrderGiftsTest() {
        PlaceOrderElements elements = new PlaceOrderElements();

        elements.giftMenu.click();

        int rand = (int) (Math.random() * elements.giftProducts.size());

        elements.giftProducts.get(rand).click();

        if (rand == 0) {
            elements.giftRec0.sendKeys("Techno");
            elements.giftName0.sendKeys("Met");
            elements.giftMessage0.sendKeys("Hello Dear");
            elements.addToCart0.click();
        } else {
            elements.giftRec1.sendKeys("Techno");
            elements.giftName1.sendKeys("Met");
            elements.giftMessage1.sendKeys("Hello Dear");
            elements.addToCart1.click();

        }
        Assert.assertTrue(elements.addedCheck.getText().contains("added"), "Ürün sepete eklenemedi.");
    }

    @Test(priority = 6)
    void OrderComputerTest() {
        PlaceOrderElements elements = new PlaceOrderElements();


        new Actions(driver).moveToElement(elements.computers).perform();
        new Actions(driver).moveToElement(elements.desktops).click().perform();

        elements.buildComp.click();

        int random = (int) (Math.random() * (4 - 1)) + 1;

        new Select(elements.ramSelect).selectByIndex(random);

        int random2 = (int) (Math.random() * 2);

        elements.hdd.get(random2).click();

        elements.getAddToCartCom.click();

        Assert.assertTrue(elements.addedCheck.getText().contains("added"), "Ürün sepete eklenemedi.");

    }

    @Parameters("wordToSearchFor")
    @Test(priority = 7)
    void ParametreliSearchTest(String wordToSearchFor) {
        PlaceOrderElements elements = new PlaceOrderElements();

        elements.searchBox.sendKeys(wordToSearchFor);
        elements.searchBtn.click();

        Assert.assertTrue(elements.searchRslt.getText().contains("Adobe Photoshop CS4"));




    }
}
