package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;
import utilities.Driver;

import java.util.Locale;

import static org.testng.Assert.assertNotEquals;


public class ProductPage extends CommonMethods {

    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Everest SM-BT11 Ince Rgb Kablosuz Mouse']")
    public WebElement urunSecimi;
    @FindBy(xpath = "//*[@id='addToCart']")
    public WebElement ilkUrunuSepeteEkle;
    @FindBy(xpath = "(//*[text()='Lunatic Gamer Shop'])[1]")
    public WebElement ilkSaticiIsmi;
    @FindBy(xpath = "//*[@class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']")
    public WebElement gelenSayfayiKapat;
    @FindBy(xpath = "(//*[@class='add-to-basket button small'])[1]")
    public WebElement ikinciUrunuSepeteEkle;
    @FindBy(xpath = "(//*[text()='İnternet Çarşın'])[1]")
    public WebElement ikinciSaticiIsmi;
    @FindBy(xpath = "//*[@id='shoppingCart']")
    public WebElement sepetimButonu;


    public static void farkliSaticilardanSecilenUrununDogrulanmasi(WebElement element1, WebElement element2) {
        assertNotEquals(element1.getText().toLowerCase(Locale.ROOT), element2.getText().toLowerCase(Locale.ROOT));
    }
}
