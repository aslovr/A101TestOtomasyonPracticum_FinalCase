package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//*[@id='txtUserName'])[1]")
    public WebElement emailMetinKutusu;
    @FindBy(xpath = "//*[@id='btnLogin']")
    public WebElement girisYapButonu1;
    @FindBy(xpath = "//*[@id='txtPassword']")
    public WebElement sifreMetinKutusu;
    @FindBy(css = "#btnEmailSelect")
    public WebElement girisYapButonu2;


}
