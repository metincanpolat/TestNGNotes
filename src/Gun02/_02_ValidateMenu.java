package Gun02;

import Utils.BaseDriver;
import Utils.Tools;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class _02_ValidateMenu extends BaseDriver {
    /*
  Senaryo
  1- Siteyi açınız.
  2- Top Menudeki menu elemanlarının olduğunu doğrulayınız.(menuValidation)
  3- Desktops, Laptops & Notebooks, Components, Tablets, Software, Phones & PDAs, Cameras, MP3 Players
 */

    @Test(groups = "SmokeTest")
    void topList() throws IOException {
    List<WebElement> listTopLine=driver.findElements(By.cssSelector("ul[class='nav navbar-nav']>li"));

    for(WebElement e :listTopLine){
        if (!(listTopLine.size() ==8)){
            Tools.takeScreenShot();
        }

        System.out.println(e.getText());
        List<String> checkList=new ArrayList<>();
        checkList.add("Desktops");
        checkList.add("Laptops & Notebooks");
        checkList.add("Components");
        checkList.add("Tablets");
        checkList.add("Software");
        checkList.add("Phones & PDAs");
        checkList.add("Cameras");
        checkList.add("MP3 Players");

        for (int i = 0; i < listTopLine.size(); i++) {
            Assert.assertEquals(listTopLine.get(i).getText(),checkList.get(i),"Başlıkta farklılık var");
        }

        Assert.assertTrue(e.isDisplayed(),e.getText()+" is NOT displayed");} //Kontrol et
    }
}
