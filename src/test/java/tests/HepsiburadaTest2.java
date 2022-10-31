package tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import page.HomePage;
import page.ProductPage;
import page.ShoppingCartPage;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.IOException;


public class HepsiburadaTest2 extends TestBaseRapor {
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    private static Logger logger = LogManager.getLogger(HepsiburadaTest2.class.getName());


    @Test
    public void kullaniciGirişiYapilmadanSepeteEkleme() throws IOException {

        // logger.info("---Kullanıcı girişi yapılmadan belirtilen ürünü sepete ekleme---");
        // extentTest = extentReports.createTest("HepsiburadaTest2", "Kullanıcı girişi yapılmadan belirtilen ürünü sepete ekleme");

        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));
        // logger.info("Kullanıcı Hepsiburada.com sitesini ziyaret eder");
        // extentTest.info("Kullanıcı Hepsiburada.com sitesini ziyaret eder");

        CommonMethods.dogrulamaMethodu(homePage.hepsiburadaLogo);
       // CommonMethods.getScreenshot("Test2_AnaSayfa");
        // logger.info("Kullanıcının doğru sayfada olduğu doğrulanir");
        // extentTest.pass("Kullanıcının doğru sayfada olduğu doğrulanir");

        CommonMethods.jsclick(homePage.cerezKabul);
        // logger.info("Kullanici çerezleri kabul eder");
        //  extentTest.info("Kullanici çerezleri kabul eder");

        HomePage.urunArama(homePage.aramaMetinKutusu);
        // logger.info("Kullanıcı, burada satın almak istediği ürün için arama yapar");
        // extentTest.info("Kullanıcı, burada satın almak istediği ürün için arama yapar");

        CommonMethods.webElementClick(productPage.urunSecimi);
        // logger.info("Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer");
        // extentTest.info("Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.");

        CommonMethods.switchWindow(1);

        CommonMethods.webElementClick(productPage.ilkUrunuSepeteEkle);
        // logger.info("Kullanıcı seçilen ürün için ilk satıcıdan ürünü sepete ekler ");
        // extentTest.info("Kullanıcı seçilen ürün için ilk satıcıdan ürünü sepete ekler");

        CommonMethods.webElementClick(productPage.gelenSayfayiKapat);
        // logger.info("Kullanıcı ürün sepetinizde,sayfasını kapatır");
        // extentTest.info("Kullanıcı ürün sepetinizde,sayfasını kapatır");

        CommonMethods.webElementClick(productPage.ikinciUrunuSepeteEkle);
        // logger.info("Kullanıcı seçilen ürün için ikinci satıcıdan ürünü sepete ekler");
        // extentTest.info("Kullanıcı seçilen ürün için ikinci satıcıdan ürünü sepete ekler");

        CommonMethods.webElementClick(productPage.gelenSayfayiKapat);
        // logger.info("Kullanıcı ürün sepetinizde,sayfasını kapatır");
        // extentTest.info("Kullanıcı ürün sepetinizde,sayfasını kapatır");

        ProductPage.farkliSaticilardanSecilenUrununDogrulanmasi(productPage.ilkSaticiIsmi, productPage.ikinciSaticiIsmi);
        // logger.info("İki farklı satıcıdan ürün seçildiği doğrulanır");
        // extentTest.pass("İki farklı satıcıdan ürün seçildiği doğrulanır");

        //Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.
        CommonMethods.webElementClick(productPage.sepetimButonu);
        // logger.info("Kullanici 'Sepetim' butonuna tıklar");
        // extentTest.info("Kullanici 'Sepetim' butonuna tıklar");

        CommonMethods.dogrulamaMethodu(shoppingCartPage.sepetim);
        // logger.info("Sepetim sayfasında olunduğu doğrulanır");
        // extentTest.pass("Sepetim sayfasında olunduğu doğrulanır");

        ShoppingCartPage.urununSepetteDogrulanmasi(productPage.urunSecimi, shoppingCartPage.sepettekiIlkUrun, shoppingCartPage.sepettekiIkinciUrun);
        // logger.info("Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanır");
        // extentTest.pass("Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanır");

        Driver.quitDriver();
        // logger.info("Tarayıcı kapatılır");
       // extentTest.info("Tarayıcı kapatılır");
       // extentReports.flush();
    }

}
