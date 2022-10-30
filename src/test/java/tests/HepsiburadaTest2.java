package tests;

/*   Bu sinifta,kullanıcı girişi yapılmadan  aranan ürün sepete eklendi  */


import org.testng.annotations.Test;
import page.HomePage;
import page.ProductPage;
import page.ShoppingCartPage;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.Driver;
import java.io.IOException;


public class HepsiburadaTest2 {
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void test() throws IOException {

        //Kullanıcı Hepsiburada.com sitesini ziyaret eder.
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));
        //Kullanıcının doğru sayfada olduğu doğrulanir.
        CommonMethods.dogrulamaMethodu(homePage.hepsiburadaLogo);
        CommonMethods.getScreenshot("AnaSayfa");
        //Kullanici çerezleri kabul eder.
        CommonMethods.jsclick(homePage.cerezKabul);
        //Kullanıcı, burada satın almak istediği ürün için arama yapar
        HomePage.urunArama(homePage.aramaMetinKutusu);
        //Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
        CommonMethods.webElementClick(productPage.urunSecimi);
        //Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
        CommonMethods.switchWindow(1);
        CommonMethods.webElementClick(productPage.ilkUrunuSepeteEkle);
        CommonMethods.webElementClick(productPage.gelenSayfayiKapat);
        CommonMethods.webElementClick(productPage.ikinciUrunuSepeteEkle);
        CommonMethods.webElementClick(productPage.gelenSayfayiKapat);
        ProductPage.farkliSaticilardanSecilenUrununDogrulanmasi(productPage.ilkSaticiIsmi, productPage.ikinciSaticiIsmi);
        //Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.
        CommonMethods.dogrulamaMethodu(shoppingCartPage.sepetim);
        CommonMethods.webElementClick(productPage.sepetimButonu);
        ShoppingCartPage.urununSepetteDogrulanmasi(productPage.urunSecimi, shoppingCartPage.sepettekiIlkUrun, shoppingCartPage.sepettekiIkinciUrun);
    }


}
