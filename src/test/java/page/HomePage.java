package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.Driver;


public class HomePage extends CommonMethods {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    public WebElement cerezKabul;
    @FindBy(xpath = "//*[@class='sf-OldHeader-exrQSXymhibjbWbIEpvR']")
    public WebElement hepsiburadaLogo;
    @FindBy(css = "#myAccount")
    public WebElement accountButonu;
    @FindBy(xpath = "//*[@id='login']")
    public WebElement girisYapButonu;
    @FindBy(xpath = "//*[text()='Hesabım']")
    public WebElement basariliGiris;
    @FindBy(xpath = "//*[@type='text']")
    public WebElement aramaMetinKutusu;


    public static void kullaniciGirisi(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        CommonMethods.hover(homePage.accountButonu);
        CommonMethods.webElementClick(homePage.girisYapButonu);
        loginPage.emailMetinKutusu.sendKeys(ConfigReader.getProperty("email"));
        CommonMethods.webElementClick(loginPage.girisYapButonu1);
        loginPage.sifreMetinKutusu.sendKeys(ConfigReader.getProperty("sifre"));
        CommonMethods.webElementClick(loginPage.girisYapButonu2);

    }
    public static void urunArama(WebElement element) {
        CommonMethods.waitFor(3);
        element.sendKeys(ConfigReader.getProperty("aranacakUrun"), Keys.ENTER);
      //  CommonMethods.waitForPageToLoad(3);
    }

}
