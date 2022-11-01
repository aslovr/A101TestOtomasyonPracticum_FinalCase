package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;
import utilities.Driver;

import java.util.List;
import java.util.Locale;

import static org.testng.Assert.assertTrue;

public class ShoppingCartPage {

    public ShoppingCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1")
    public WebElement sepetim;
    @FindBy(xpath = "(//*[text()='Everest SM-BT11 Ince Rgb Kablosuz Mouse'])[1]")
    public WebElement sepettekiIlkUrun;
    @FindBy(xpath = "(//*[text()='Everest SM-BT11 Ince Rgb Kablosuz Mouse'])[2]")
    public WebElement sepettekiIkinciUrun;
    @FindBy(css = ".delete_product_3DFC0")
    public WebElement sepetiTemizleme;


    public static void urununSepetteDogrulanmasi(WebElement x, WebElement y, WebElement z) {
        String secilenUrun = x.getText().toLowerCase(Locale.ROOT);
        String sepetBirinciUrun = y.getText().toLowerCase(Locale.ROOT);
        String sepetIkinciUrun = z.getText().toLowerCase(Locale.ROOT);
        if (sepetBirinciUrun.equals(sepetIkinciUrun)) {
            assertTrue(secilenUrun.contains(sepetBirinciUrun) && secilenUrun.contains(sepetIkinciUrun));
        } else {
            System.out.println("Seçilen Urun sepete hatali eklenmiştir");
        }
    }


    public static void sepetiTemizlemeveSayfayiKapat(WebElement element) {

        CommonMethods.hover(element);
        CommonMethods.waitForClickablility(element,3);
        CommonMethods.webElementClick(element);
        CommonMethods.webElementClick(Driver.getDriver().findElement(By.xpath("//*[@class='sc-AxjAm iDSyON favoritesButton_q2rtP']")));
        CommonMethods.hover(element);
        CommonMethods.webElementClick(element);
        Driver.quitDriver();

    }


}


