package Gun07;

import Utils.BaseDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class _01_WishList extends BaseDriver
    /*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.

 */
{
    @Parameters("wordToSearchFor")
    @Test
    void wishListCheck(String wordToSearchFor){

        _01_zWishListElements elements = new _01_zWishListElements();

        elements.searchBox.sendKeys(wordToSearchFor);
        elements.searchBtn.click();

        int random=(int) (Math.random()*elements.addWishBtnList.size());

        String wishItemText=elements.searchRsltList.get(random).getText();

        elements.addWishBtnList.get(random).click();

        Tools.successMessageValidation();

//       WebElement close=waitAWhile.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[class='close']"))));
//        close.click();

        //new Actions(driver).pause(Duration.ofSeconds(4));

        Tools.Wait(3);



        //elements.newsletter.click();
        waitAWhile.until(ExpectedConditions.elementToBeClickable(elements.wishListBtn));

        //new Actions(driver).scrollToElement(elements.wishListBtn).perform();

        //JavascriptExecutor js=(JavascriptExecutor) driver;

        //js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

//        for (int i = 0; i < 4; i++) {
//
//            js.executeScript("window.scrollBy(0,500)");
//            Tools.Wait(1);
//        }



        elements.wishListBtn.click();

        Boolean success=false;
        for (WebElement e : elements.wishListRslt)
            if (e.getText().equalsIgnoreCase(wishItemText)){
                success=true;
                break;
            }
        if (!success)
            Assert.fail("The text NOT found");

    }

}
