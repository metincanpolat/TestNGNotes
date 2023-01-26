package PROJELER.Proje_02.Pages;

import PROJELER.Proje_02.Proje02DriverPA;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftNav extends Proje02DriverPA {

    public LeftNav(){
        PageFactory.initElements(Proje02DriverPA.driver,this);}


    @FindBy(xpath = "//a[@class='nav-link']/child::i[contains(@class,'nav-icon fas')or@class='nav-icon far fa-user']")
    public List<WebElement> navBarMenu;

    public ArrayList<String> navBarMenuStr=new ArrayList<>(Arrays.asList("Catalog","Sales","Customers","Promotions","Content management","Configuration","System","Reports","Help"));

    @FindBy(xpath = "//*[@class='nav-item has-treeview menu-open']/descendant::i[@class='nav-icon far fa-dot-circle']/following-sibling::p")
    public List<WebElement> navBarSubMenu;

    //public ArrayList<String> navBarSubMenuStr=new ArrayList<>(Arrays.asList("Products","Categories","Manufacturers","Product reviews","Product tags","Attributes"));


    @FindBy(xpath = "//li[@class='nav-item has-treeview menu-open']")
    public WebElement elementOpen;

    @FindBy(xpath = "//li[@class='nav-item has-treeview']")
    public WebElement elementClose;

    @FindBy(xpath = "//ul[@class='nav nav-treeview']")
    public WebElement style;





}
