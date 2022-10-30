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
    @FindBy(xpath = "//*[@type='text']")
    public WebElement aramaMetinKutusu;


    public static void urunArama(WebElement element) {
        CommonMethods.waitFor(3);
        element.sendKeys(ConfigReader.getProperty("aranacakUrun"), Keys.ENTER);
      //  CommonMethods.waitForPageToLoad(3);
    }

}
