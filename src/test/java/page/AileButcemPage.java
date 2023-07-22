package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AileButcemPage {

    public AileButcemPage() {

        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);
    }

    @FindBy(xpath = "//*[@text='E-mail Adresi']")
    public WebElement emailBox; // Email Kutusu

    @FindBy(xpath = "//*[@text='Şifre']")
    public WebElement passwordBox; //passwordKutusu


    @FindBy(xpath = "//*[@text='Bütçem']")
    public WebElement butcemText; //Giriş yapıldıktan sonraki sayfada bulunan ana başlık locate


    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public WebElement nameBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public WebElement lastNameBox;
    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    public WebElement cityBox;



    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[4]")
    public WebElement YearBox;
    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[5]")
    public WebElement jobBox;


}


