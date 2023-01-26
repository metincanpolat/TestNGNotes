package PROJELER.Proje_01;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaceOrderElements {

    public PlaceOrderElements() {
        PageFactory.initElements(Proje01Driver.driver, this);
    }



    /******** MAIN PAGE ********/

    @FindBy(linkText = "Register")
    public WebElement registerLink;

    @FindBy(linkText = "Log in")
    public WebElement login;

    @FindBy(linkText = "My account")
    public WebElement myAccount;

    @FindBy(linkText = "Log out")
    public WebElement logOut;

    @FindBy(css = "[class='top-menu notmobile']>li>a")
    public List<WebElement> tabMenu;


    List<String> tabMenuListStr= new ArrayList<>(Arrays.asList("Computers","Electronics",
            "Apparel","Digital downloads","Books","Jewelry","Gift Cards"));

    @FindBy(id = "small-searchterms")
    public WebElement searchBox;

    @FindBy(css = "[class='button-1 search-box-button']")
    public WebElement searchBtn;



    /******   GIFT   ******/
    @FindBy(linkText = "Gift Cards")
    public WebElement giftMenu;

    @FindBy(xpath = "//a[@href='/50-physical-gift-card']")
    public List<WebElement> giftProducts;

    @FindBy(id = "giftcard_44_RecipientName")
    public WebElement giftRec0;

    @FindBy(id = "giftcard_44_SenderName")
    public WebElement giftName0;

    @FindBy(id = "giftcard_44_Message")
    public WebElement giftMessage0;

    @FindBy(id = "add-to-cart-button-44")
    public WebElement addToCart0;

/*******/

    @FindBy(id = "giftcard_45_RecipientName")
    public WebElement giftRec1;

    @FindBy(id = "giftcard_45_SenderName")
    public WebElement giftName1;

    @FindBy(id = "giftcard_45_Message")
    public WebElement giftMessage1;

    @FindBy(id = "add-to-cart-button-45")
    public WebElement addToCart1;

    @FindBy(css = "p[class='content']")
    public WebElement addedCheck;





    /******* REGISTER PAGE *******/

    @FindBy(id = "gender-male")
    public WebElement genderMale;

    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
    public WebElement dateOfBirthDay;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement dateOfBirthMonth;

    @FindBy(name = "DateOfBirthYear")
    public WebElement dateOfBirthYear;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(id = "register-button")
    public WebElement registerBtn;

    /******* Control ******/

    @FindBy(className = "result")
    public WebElement resulText;

    @FindBy(css = "[class^='message-error']")
    public WebElement resulTextWrong;



    /********  LOGIN  *******/

    //email ve password ortak locator.

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement logInBtn;

    /****** COMPUTERS ******/

    @FindBy(linkText = "Computers")
    public WebElement computers;

    @FindBy(linkText = "Desktops")
    public WebElement desktops;

    @FindBy(linkText = "Build your own computer")
    public WebElement buildComp;

    @FindBy(id = "product_attribute_2")
    public WebElement ramSelect;

    @FindBy(name = "product_attribute_3")
    public List<WebElement> hdd;

    @FindBy(id = "add-to-cart-button-1")
    public WebElement getAddToCartCom;

    /***** SEARCH *****/

    @FindBy(css = "h2[class='product-title']>a")
    public WebElement searchRslt;
















}
