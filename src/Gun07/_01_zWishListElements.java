package Gun07;

import Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _01_zWishListElements {

    public _01_zWishListElements(){PageFactory.initElements(BaseDriver.driver,this);}

    @FindBy(name = "search")
    public WebElement searchBox;

    @FindBy(css = "[class='btn btn-default btn-lg']")
    public WebElement searchBtn;

    @FindBy(css = "button>[class='fa fa-heart']")
    public List<WebElement> addWishBtnList;

    @FindBy(css = "h4>a")
    public List<WebElement> searchRsltList;

    @FindBy(xpath = "//a[text()='Wish List']")
    public WebElement wishListBtn;

    @FindBy(css = "[class='text-left']>a")
    public List<WebElement> wishListRslt;

    @FindBy(linkText = "Newsletter")
    public WebElement newsletter;




}
