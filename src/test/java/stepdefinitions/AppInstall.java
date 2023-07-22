package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.ConfigReader;
import utilities.Driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppInstall {


    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    static final String TELEFONADI = "Pixel 2";
    static final String ANDROIDVERSION = "10.0";
    static final String PLATFORM = "Android";
    static final String OTOMASYON_ISMI = "UiAutomator2";

    @Given("Kullanici gerekli bilgileri girerek {string} apk yuklemesi yapar")
    public void kullanici_gerekli_bilgileri_girerek_apk_yuklemesi_yapar(String apk) throws MalformedURLException {

        DesiredCapabilities caps =new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, TELEFONADI);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ANDROIDVERSION);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, OTOMASYON_ISMI);
        caps.setCapability(MobileCapabilityType.APP, ConfigReader.getProperty(apk)); // "ailebutcem"
        caps.setCapability(MobileCapabilityType.NO_RESET,false);
        // true uygulama sifirlanmiyor onceki adimlari muhafaza ediyor
        //false ise her test baslangicinda uygulamayi sifirliyor ve uygulama en bastan basliyor
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

}
