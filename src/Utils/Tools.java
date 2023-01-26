package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static Utils.BaseDriver.driver;
import static Utils.BaseDriver.waitAWhile;

public class Tools {

    public static void Wait(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void successMessageValidation(){
        WebElement checkMsg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        waitAWhile.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        Assert.assertTrue(checkMsg.getText().toLowerCase().contains("success"));
    }




    public static void takeScreenShot() throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File memory=ts.getScreenshotAs(OutputType.FILE);

        LocalDateTime dt=LocalDateTime.now();
        String dateTimeSrg=dt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
        dateTimeSrg=dateTimeSrg.replace(" ","-").replace(".","_").replace(":","_");

        FileUtils.copyFile(memory,new File("screenShots\\screenshot_"+dateTimeSrg+".png"));
    }
}
