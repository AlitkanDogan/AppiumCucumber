package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserDriver;
import utilities.Driver;

public class AmazonPage {
    public AmazonPage() {

        PageFactory.initElements((WebDriver) BrowserDriver.getBrowserDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement searchBox; // Arama Kutusu
}
