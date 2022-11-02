# A101TestOtomasyonPracticum_FinalCase
Bu proje Patika.dev ve A101 Yeni Mağazacılık A.Ş. İş Birliği ile açılan Practicum'a ait Final case çalışmasıdır.

# Kullanılan Teknolojiler
+ IDE olarak IntelliJ kullanılmıştır.  

+ Projenin yazıldığı kodlama dili Java'dır.

+ Projeyi yapılandırmak için Maven repo kullanılmıştır.

+ Web Sitesini test etmek için Selenium Test Otomasyon Aracı kullanılmıştır.

+ Test yazım aracı olarak TestNG kütüphanesi kullanılmıştır.

+ Mimaride Page Object Model kullanılmıştır.

+ OOP prensiplerine uygun geliştirilmiştir.

+ Detaylı log bilgilerini görmek için log4j kütüphanesi kullanıldı.

# Proje Yapısının Açıklanması
Projede aşağıda görmüş olduğunuz yapıyı kullandım;

![proje yapısı](https://user-images.githubusercontent.com/111223290/199602424-2b70d353-d20a-452b-a55a-3de7758f2ae9.png)

+ **pages:** Pages klasörünün yaratılma sebebi Page Object Model kalıbını uygulamaktır. İçerisinde caselerde kullanılan tüm sayfalar sınıflar aracılığıyla temsil edilir. Pages Klasörü içerisinde aşağıdaki sınıflar yer alır.
  + **HomePage:** Kullanıcıyı karşılayan Ana Sayfadır(hepsiburada.com). Login için ilk hareket ve ürün arama işlemleri bu sayfa üzerinden yapılır.
  + **LoginPage:** Üye Giriş Sayfasıdır. Kullanıcı login işlemleri bu sayfa üzerinden yapılır.
  + **ProductPage:** Ürün Sayfasıdır. Ürün seçimleri bu sayfa üzerinden kontrol edilir.
  + **ShoppingCartPage:** Kullanıcı Sepeti Sayfasıdır.
+ **tests:** Testcaselerin yazılmış olduğu sınıfları içerir.İçerisinde 2 class mevcuttur.
   + **finalCase1:** Kullanıcı girişi yapılarak sepete ürün eklenmesi ile ilgili test senaryosudur.
   + **finalCase2:** Kullanıcı girişi yapılmadan belirtilen ürünü sepete ekleme ile ilgili test senaryosudur.
+ **utilities:** Dosyada sürekli lazım olan classlar ve methodlar bulunuyor. Kod tasarrufuna gitmeyi ve projeyi daha anlaşılır hale getirmeyi sağlıyor.İçerisinde 
aşağıda yer alan sınıflar mevcuttur.
   + **CommonMethods:** Sık kullanılan methodlar okunulabilirliğin artırılması ve herhangi bir değişiklik yapılabilmesine esneklik sağlayabilmesi
                        için bu sınıf içerisinde tanımlanmıştır.
   + **ConfigReader:** Test metodundan yollağımız string key değerini alıp Properties class'ından getProperty() methodunu kullanarak bu key' e ait value'yu bize                               getirir
   + **Driver:** Bu sınıf ile driverları ayağa kaldırma, ilk url girme, driver sonlandırma gibi işlemler yapılabilir.
   + **TestBaseRapor:** TestNG kütüphanesinde html rapor almak için methodlar içerir.
   + **resources:** log bilgilerinin, html raporunun ve ekran resimlerinin olduğu klasördür. 
   + **tumClasslariCalistirma.xml:** Sınıflari teker teker gidip çalıştırmak yerine,tüm testleri çalıştırmak için xml dosyası kullandım.
   + **configuration.properties:** Properties dosyamızda sürekli kullandığımız variablelarımız bulunmakta,ConfigReader classı içindeki method sayesinde bu dosyada                                        bulunan dataları istediğimiz yerlere çağırabiliriz.
   + **pom.xml:** Maven projesi ile gelen bir xml dosyasıdır. Projede kullanılacak olan frameworkleri tanımladığımız bir yapıdır.

# Örnek Ekran Çıktıları
+ log yapısının çıkısı

![log ekrani](https://user-images.githubusercontent.com/111223290/199615654-546d0cb2-3ed9-4433-8407-4cbae47b86a6.png)


+ TestNG Reports html raporunun görüntüsü

![testNG report-1](https://user-images.githubusercontent.com/111223290/199615850-39f8ee54-1355-4eff-b0b0-d6e3b86a1ea0.png)
![testNG report-2](https://user-images.githubusercontent.com/111223290/199615856-41472af8-80fc-425d-8c2b-1e8e2c13785c.png)

