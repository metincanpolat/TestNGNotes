package PROJELER.Proje_02;

import PROJELER.Proje_02.Pages.DialogContent;
import PROJELER.Proje_02.Pages.LeftNav;
import PROJELER.Proje_02.Pages.Parent;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Proje02_Runner extends Parent {



    @Test(priority = 1)
    void LoginTest() {
        DialogContent dc = new DialogContent();

        sendKeysFunction(dc.email, "admin@yourstore.com");
        sendKeysFunction(dc.password, "admin");
        clickFunction(dc.logInBtn);
        textCheckAssert(dc.dashBoardText, "Dashboard");
    }
    @Test(priority = 2)
    void CheckLeftNawMenu(){
        LeftNav ln = new LeftNav();

        driver.findElement(By.cssSelector("[class='fas fa-minus']")).click();


        for (int i = 8; i < ln.navBarMenu.size(); i--) {

            clickFunction(ln.navBarMenu.get(i));
            //waitAWhile.until(ExpectedConditions.attributeToBe(ln.elementOpen,"class","nav-item has-treeview menu-open"));
            System.out.println(ln.navBarSubMenu.size());
            //waitAWhile.until(ExpectedConditions.attributeToBe(ln.style,"style","display: block;"));
            clickFunction(ln.navBarMenu.get(i));

            //waitAWhile.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@class='nav-item has-treeview menu-open']/descendant::i[@class='nav-icon far fa-dot-circle']/following-sibling::p)"),0));
            //waitAWhile.until(ExpectedConditions.attributeToBe(ln.style,"style","display: none;"));
            waitAWhile.until(ExpectedConditions.attributeToBe(ln.elementClose,"class","nav-item has-treeview"));

            //waitAWhile.until(ExpectedConditions.invisibilityOf(ln.elementOpen));

            //Tools.Wait(1);

//            Assert.assertTrue(ln.elementOpen.getAttribute("class").toLowerCase().contains("menu-open"));
            //clickFunction(ln.navBarMenu.get(i));
            //waitAWhile.until(ExpectedConditions.stalenessOf(ln.navBarMenu.get(i)));
//            clickFunction(i);
//            System.out.println(ln.navBarSubMenu.size());
//            Assert.assertTrue(ln.navBarSubMenu.size()>0,"Menu doesn't have title");

        }

//        for (WebElement e : ln.navBarMenu){
//            clickFunction(e);
//            waitAWhile.until(ExpectedConditions.stalenessOf(e));
//            clickFunction(e);
//            System.out.println(ln.navBarSubMenu.size());
//            Assert.assertTrue(ln.navBarSubMenu.size()>0,"Menu doesn't have title");
//        }

//        for (WebElement e : ln.navBarMenu){
//            clickFunction(e);
//            waitAWhile.until(ExpectedConditions.attributeToBe(ln.elementOpen,"class","nav-item has-treeview menu-open"));
//            clickFunction(e);
//            waitAWhile.until(ExpectedConditions.attributeToBe(ln.style,"style","display: none;"));
//
//
//            waitAWhile.until(ExpectedConditions.attributeToBe(ln.elementClose,"class","nav-item has-treeview"));
//
//            //Tools.Wait(1);
//        }


    }

    @Test(priority = 3)
    void CreateCustomer(){



    }
//
//    @Test(priority = 3, dataProvider = "getData")
//    void DataProviderLogin(String email, String password, String check) {
//
//        PlaceOrderElements elements = new PlaceOrderElements();
//
//        elements.login.click();
//        elements.email.sendKeys(email);
//        elements.password.sendKeys(password);
//        elements.logInBtn.click();
//        if (check.equalsIgnoreCase("wrong")) {
//            Assert.assertTrue(elements.resulTextWrong.getText().toLowerCase().contains("unsuccessful"));
//        } else {Assert.assertEquals(elements.logOut.getText().toLowerCase(), "log out");
//        elements.logOut.click();}
//
//    }
//
//    @DataProvider
//    Object[][] getData() {
//
//        Object[][] logins = {
//                {"wrongEmail@technoStudy.com", "1225215", "wrong"},
//                {"abc@technostudy.com", "123456", "my account"}
//        };
//        return logins;
//    }
//
//    @Test(priority = 4)
//    void TabMenuTest() {
//        PlaceOrderElements elements = new PlaceOrderElements();
//
//        for (int i = 0; i < elements.tabMenuListStr.size(); i++)
//            Assert.assertEquals(elements.tabMenu.get(i).getText(), elements.tabMenuListStr.get(i));
//    }
//
//    @Test(priority = 5)
//    void OrderGiftsTest() {
//        PlaceOrderElements elements = new PlaceOrderElements();
//
//        elements.giftMenu.click();
//
//        int rand = (int) (Math.random() * elements.giftProducts.size());
//
//        elements.giftProducts.get(rand).click();
//
//        if (rand == 0) {
//            elements.giftRec0.sendKeys("Techno");
//            elements.giftName0.sendKeys("Met");
//            elements.giftMessage0.sendKeys("Hello Dear");
//            elements.addToCart0.click();
//        } else {
//            elements.giftRec1.sendKeys("Techno");
//            elements.giftName1.sendKeys("Met");
//            elements.giftMessage1.sendKeys("Hello Dear");
//            elements.addToCart1.click();
//
//        }
//        Assert.assertTrue(elements.addedCheck.getText().contains("added"), "Ürün sepete eklenemedi.");
//    }
//
//    @Test(priority = 6)
//    void OrderComputerTest() {
//        PlaceOrderElements elements = new PlaceOrderElements();
//
//
//        new Actions(driver).moveToElement(elements.computers).perform();
//        new Actions(driver).moveToElement(elements.desktops).click().perform();
//
//        elements.buildComp.click();
//
//        int random = (int) (Math.random() * (4 - 1)) + 1;
//
//        new Select(elements.ramSelect).selectByIndex(random);
//
//        int random2 = (int) (Math.random() * 2);
//
//        elements.hdd.get(random2).click();
//
//        elements.getAddToCartCom.click();
//
//        Assert.assertTrue(elements.addedCheck.getText().contains("added"), "Ürün sepete eklenemedi.");
//
//    }
//
//    @Parameters("wordToSearchFor")
//    @Test(priority = 7)
//    void ParametreliSearchTest(String wordToSearchFor) {
//        PlaceOrderElements elements = new PlaceOrderElements();
//
//        elements.searchBox.sendKeys(wordToSearchFor);
//        elements.searchBtn.click();
//
//        Assert.assertTrue(elements.searchRslt.getText().contains("Adobe Photoshop CS4"));
//
//
//
//
//    }
}
