package stepdefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.AileButcemPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class AileButcem {
    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    AileButcemPage aileButcemPage=new AileButcemPage();
    TouchAction touchAction = new TouchAction<>(driver);

    @Given("kullanıcı driver kurulumlarını yapar")
    public void kullanıcı_driver_kurulumlarını_yapar() {
        Driver.getAndroidDriver();
    }

    @Given("ilk ekran ayarlarini yapin ve ardindan login sayfasina ulasin")
    public void ilk_ekran_ayarlarini_yapin_ve_ardindan_login_sayfasina_ulasin() throws InterruptedException {
        ReusableMethods.bekle(5);
        for (int i = 0; i < 6; i++) {
            ReusableMethods.ekranKaydirma(902, 871, 69, 871, 200);
        }
        ReusableMethods.kordinatTikla(538,1172);
        ReusableMethods.bekle(1
        );

    }

    @Given("{string} ve {string} bilgilerini girerek kullanici bilgileriyle giris yapin")
    public void ve_bilgilerini_girerek_kullanici_bilgileriyle_giris_yapin(String string, String string2) throws InterruptedException {

        ReusableMethods.bekle(2);

        aileButcemPage.emailBox.sendKeys(ConfigReader.getProperty(string));
        aileButcemPage.passwordBox.sendKeys(ConfigReader.getProperty(string2));
        ReusableMethods.bekle(1);
        ReusableMethods.kordinatTikla(579,1471);
        ReusableMethods.bekle(6);
    }


    @Given("uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin")
    public void uygulamaya_kullanici_bilgileriyle_giris_yapildigini_dogrulayin() throws InterruptedException {
        Assert.assertTrue(aileButcemPage.butcemText.isDisplayed());
    }

    @Given("sol kisimdaki menuden hesabim bolumune gidin")
    public void sol_kisimdaki_menuden_hesabim_bolumune_gidin(){
        ReusableMethods.kordinatTikla(113,135);
        ReusableMethods.kordinatTikla(373,769);
    }

    @Given("hesabim sayfasindaki bilgileri degistirerek degisikleri kaydedin")
    public void hesabim_sayfasindaki_bilgileri_degistirerek_degisikleri_kaydedin() {
        ReusableMethods.bekle(4);
        aileButcemPage.nameBox.clear();
        ReusableMethods.bekle(1);
        aileButcemPage.nameBox.sendKeys(ConfigReader.getProperty("name"));
        ReusableMethods.bekle(1);

        aileButcemPage.lastNameBox.clear();
        ReusableMethods.bekle(1);
        aileButcemPage.lastNameBox.sendKeys(ConfigReader.getProperty("lastname"));
        ReusableMethods.bekle(1);

        aileButcemPage.cityBox.clear();
        ReusableMethods.bekle(1);
        aileButcemPage.cityBox.sendKeys(ConfigReader.getProperty("city"));
        ReusableMethods.bekle(1);


        aileButcemPage.YearBox.clear();
        ReusableMethods.bekle(1);
        aileButcemPage.YearBox.sendKeys(ConfigReader.getProperty("year"));
        ReusableMethods.bekle(1);

        aileButcemPage.jobBox.clear();
        ReusableMethods.bekle(1);
        aileButcemPage.jobBox.sendKeys(ConfigReader.getProperty("job"));
        ReusableMethods.bekle(1);

        ReusableMethods.kordinatTikla(436,1677);
        ReusableMethods.bekle(3);



    }

    @Given("ardindan degisiklerin yapildigini dogrulayin")
    public void ardindan_degisiklerin_yapildigini_dogrulayin() {

        String expected=ConfigReader.getProperty("name");
        String actual= aileButcemPage.nameBox.getText();
        Assert.assertEquals(expected,actual);

    }

    //===========================================

    @When("anasayfadaki arti butonuna tiklayin")
    public void anasayfadaki_arti_butonuna_tiklayin() {

    }
    @When("gelir ekle bolumune tiklayin")
    public void gelir_ekle_bolumune_tiklayin() {

    }
    @When("aciklama,gelir tip, kategori, tarih ve tutari belirleyin ve kaydedin")
    public void aciklama_gelir_tip_kategori_tarih_ve_tutari_belirleyin_ve_kaydedin() {

    }
    @When("basariyla eklendigini dogrulayin")
    public void basariyla_eklendigini_dogrulayin() {

    }
    @When("uygulamayı kapatın")
    public void uygulamayı_kapatın() {
        Driver.quitAppiumDriver();
    }
}
