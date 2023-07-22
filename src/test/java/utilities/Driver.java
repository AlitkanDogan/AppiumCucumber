package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static AndroidDriver appiumDriver;


    public static AndroidDriver getAndroidDriver() {
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http:127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (appiumDriver == null) {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("TELEFONADI"));
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("ANDROIDVERSION"));
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("PLATFORM"));
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("OTOMASYON_ISMI"));
            //==============ARABAM.COM====================
            //caps.setCapability("appPackage", "com.dogan.arabam");
            //caps.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");

            //==============KİWİ.COM====================
            // caps.setCapability("appPackage", "com.skypicker.main");
            // caps.setCapability("appActivity", "com.kiwi.android.feature.splash.impl.ui.SplashActivity");

            //==============ALL-CURRENCY====================
           // caps.setCapability("appPackage", "com.smartwho.SmartAllCurrencyConverter");
           // caps.setCapability("appActivity", "com.smartwho.SmartAllCurrencyConverter.CurrencyConverter");

            //==============AILE-BUTCEM====================
            //caps.setCapability("appPackage", "com.ailebutcem");
           // caps.setCapability("appActivity", "com.ailebutcem.MainActivity");

            caps.setCapability(MobileCapabilityType.NO_RESET, false);
            // true uygulama sifirlanmiyor onceki adimlari muhafaza ediyor
            //false ise her test baslangicinda sifirliyor

            if (ConfigReader.getProperty("platformName").equals("Android")) {

                assert appiumServerURL != null;
                appiumDriver = new AndroidDriver<>(appiumServerURL, caps);
                appiumDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            } else {

                throw new UnsupportedOperationException("Invalid Platform Name ");

            }

        }

        return appiumDriver;
    }


    public static void quitAppiumDriver() {
        if (appiumDriver != null) {
            appiumDriver.closeApp();
            appiumDriver = null;
        }
    }
}
