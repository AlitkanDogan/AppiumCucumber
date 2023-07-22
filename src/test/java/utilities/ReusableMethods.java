package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {
    static  TouchAction touchAction=new TouchAction<>(Driver.getAndroidDriver());

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getAndroidDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void adimGecme(int adimSayisi,int x,int y) throws InterruptedException {
        for (int i = 0; i < adimSayisi; i++) {
            touchAction.press(PointOption.point(x,y)).release().perform();;
            Thread.sleep(1000);
        }
    }
    public static void kordinatTikla(int x,int y){

        touchAction.press(PointOption.point(x,y)).release().perform();;
        ReusableMethods.bekle(1);

    }

    public static void ekranKaydirma(int first_X,int first_Y,int last_X,int last_Y, int speedTime) throws InterruptedException {
        touchAction
                .press(PointOption.point(first_X, first_Y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(speedTime)))
                .moveTo(PointOption.point(last_X, last_Y))
                .release().perform();

        ReusableMethods.bekle(1);
    }

    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            System.out.println("Bekle ReusableMethod Hatası");
        }
    }
    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        driver.findElementByXPath("//*[@text='" + elementText + "']").click();
    }
    public static void jseClick(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getAndroidDriver();
        jse.executeScript("arguments[0].click();",webElement);
    }

    public static void jseClickWeb(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor) BrowserDriver.getBrowserDriver();
        jse.executeScript("arguments[0].click();",webElement);
    }


}
