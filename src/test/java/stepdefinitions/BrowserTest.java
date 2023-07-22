package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;

import org.openqa.selenium.Keys;
import page.AmazonPage;
import utilities.BrowserDriver;
import utilities.ConfigReader;
import utilities.ReusableMethods;


public class BrowserTest {

    AndroidDriver<AndroidElement> driver = BrowserDriver.getBrowserDriver();
    AmazonPage amazonPage=new AmazonPage();


    @Given("Kullanıci browser kurulumlarini yapar")
    public void kullanıci_browser_kurulumlarini_yapar() {

        //BrowserDriver.getBrowserDriver();


    }
    @Given("Kullanıcı {string} sayfasına gider")
    public void kullanıcı_sayfasına_gider(String string) {
  driver.get(ConfigReader.getProperty("url"));

    }

    @Given("Kullanıcı nutella aratır.")
    public void kullanıcı_nutella_aratır() throws InterruptedException {

        Thread.sleep(1000);
        amazonPage.searchBox.sendKeys("Nutella"+ Keys.ENTER);
        amazonPage.searchBox.submit();
    }
}
