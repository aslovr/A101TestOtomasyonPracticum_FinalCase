package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.ProductPage;
import page.ShoppingCartPage;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.IOException;

public class finalCase1 extends TestBaseRapor {
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    private static final Logger logger = LogManager.getLogger(finalCase1.class.getName());

    @Test
    public void kullaniciGirisiYapilarakSepeteEkleme() throws IOException {
        homePage = new HomePage();
        loginPage = new LoginPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();

        logger.info("---Kullanıcı girişi yapılarak sepete ürün eklenmesi---");
        extentTest = extentReports.createTest("finalCase1", "Kullanıcı girişi yapılarak sepete ürün eklenmesi");

        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));
        logger.info("Kullanıcı Hepsiburada.com sitesini ziyaret eder");
        extentTest.info("Kullanıcı Hepsiburada.com sitesini ziyaret eder");

        CommonMethods.dogrulamaMethodu(homePage.hepsiburadaLogo);
        CommonMethods.getScreenshot("GirisYapılarak_AnaSayfa");
        logger.info("Kullanıcının doğru sayfada olduğu doğrulanir");
        extentTest.pass("Kullanıcının doğru sayfada olduğu doğrulanir");

        CommonMethods.jsclick(homePage.cerezKabul);
        logger.info("Kullanici çerezleri kabul eder");
        extentTest.info("Kullanici çerezleri kabul eder");

        HomePage.kullaniciGirisi();
        logger.info("Kullanici gecerli e-mail ve sifre ile giris yapar");
        extentTest.info("Kullanici gecerli e-mail ve sifre ile giris yapar");

        CommonMethods.dogrulamaMethodu(homePage.basariliGiris);
        logger.info("Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır");
        extentTest.pass("Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır");

        HomePage.urunArama(homePage.aramaMetinKutusu);
        logger.info("Kullanıcı, burada satın almak istediği ürün için arama yapar");
        extentTest.info("Kullanıcı, burada satın almak istediği ürün için arama yapar");

        CommonMethods.webElementClick(productPage.urunSecimi);
        logger.info("Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer");
        extentTest.info("Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.");

        CommonMethods.switchWindow(1);

        CommonMethods.webElementClick(productPage.ilkUrunuSepeteEkle);
        logger.info("Kullanıcı seçilen ürün için ilk satıcıdan ürünü sepete ekler ");
        extentTest.info("Kullanıcı seçilen ürün için ilk satıcıdan ürünü sepete ekler");

        CommonMethods.webElementClick(productPage.gelenSayfayiKapat);
        logger.info("Kullanıcı ürün sepetinizde,sayfasını kapatır");
        extentTest.info("Kullanıcı ürün sepetinizde,sayfasını kapatır");

        CommonMethods.webElementClick(productPage.ikinciUrunuSepeteEkle);
        logger.info("Kullanıcı seçilen ürün için ikinci satıcıdan ürünü sepete ekler");
        extentTest.info("Kullanıcı seçilen ürün için ikinci satıcıdan ürünü sepete ekler");

        CommonMethods.webElementClick(productPage.gelenSayfayiKapat);
        logger.info("Kullanıcı ürün sepetinizde,sayfasını kapatır");
        extentTest.info("Kullanıcı ürün sepetinizde,sayfasını kapatır");

        ProductPage.farkliSaticilardanSecilenUrununDogrulanmasi(productPage.ilkSaticiIsmi, productPage.ikinciSaticiIsmi);
        logger.info("İki farklı satıcıdan ürün seçildiği doğrulanır");
        extentTest.pass("İki farklı satıcıdan ürün seçildiği doğrulanır");

        CommonMethods.webElementClick(productPage.sepetimButonu);
        logger.info("Kullanici 'Sepetim' butonuna tıklar");
        extentTest.info("Kullanici 'Sepetim' butonuna tıklar");

        CommonMethods.dogrulamaMethodu(shoppingCartPage.sepetim);
        logger.info("Sepetim sayfasında olunduğu doğrulanır");
        extentTest.pass("Sepetim sayfasında olunduğu doğrulanır");

        ShoppingCartPage.urununSepetteDogrulanmasi(productPage.urunSecimi, shoppingCartPage.sepettekiIlkUrun, shoppingCartPage.sepettekiIkinciUrun);
        logger.info("Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanır");
        extentTest.pass("Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanır");

        ShoppingCartPage.sepetiTemizleme(shoppingCartPage.urunuKaldir, shoppingCartPage.urunAzalt);
        logger.info("Sepetteki ürünler temizlenir");
        extentTest.info("Sepetteki ürünler temizlenir");

        Driver.quitDriver();
        logger.info("Tarayıcı kapatılır");
        extentTest.info("Tarayıcı kapatılır");
        extentReports.flush();
        logger.info("==============================================");
    }


}
