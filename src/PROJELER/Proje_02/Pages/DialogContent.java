package PROJELER.Proje_02.Pages;


import PROJELER.Proje_02.Proje02DriverPA;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Proje02DriverPA {

    public DialogContent(){
        PageFactory.initElements(Proje02DriverPA.driver,this);}

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement logInBtn;

    @FindBy(css = "[class='content-header']>h1")
    public WebElement dashBoardText;








}
