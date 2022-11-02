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

+ **pages:** Pages klasörünün yaratılma sebebi Pape Object Model kalıbını uygulamaktır. İçerisinde caselerde kullanılan tüm sayfalar sınıflar aracılığıyla temsil edilir. Pages Klasörü içerisinde aşağıdaki sınıflar yer alır.
  + **HomePage:** Kullanıcıyı karşılayan Ana Sayfadır(hepsiburada.com). Login için ilk hareket ve ürün arama işlemleri bu sayfa üzerinden yapılır.
  + **LoginPage:** Üye Giriş Sayfasıdır. Kullanıcı login işlemleri bu sayfa üzerinden yapılır.
  + **ProductPage:** Ürün Sayfasıdır. Ürün seçimleri bu sayfa üzerinden kontrol edilir.
  + **ShoppingCartPage:** Kullanıcı Sepeti Sayfasıdır.
+ **tests:** Testcaselerin yazılmış olduğu sınıfları içerir.İçerisinde 2 class mevcuttur.
   + **finalCase1:** Kullanıcı girişi yapılarak sepete ürün eklenmesi ile ilgili test senaryosudur.
   + **finalCase2:** Kullanıcı girişi yapılmadan belirtilen ürünü sepete ekleme ile ilgili test senaryosudur.
+ **utilities:** Dosyada sürekli lazım olan classlar ve methodlar bulunuyor. Kod tasarrufuna gitmeyi ve projeyi daha anlaşılır hale getirmeyi sağlıyor.İçerisinde 
aşağıda yer alan sınıflar mevcuttur.
  + **HomePage:** Kullanıcıyı karşılayan Ana Sayfadır(hepsiburada.com). Login için ilk hareket ve ürün arama işlemleri bu sayfa üzerinden yapılır.
  + **LoginPage:** Üye Giriş Sayfasıdır. Kullanıcı login işlemleri bu sayfa üzerinden yapılır.
  + **ProductPage:** Ürün Sayfasıdır. Ürün seçimleri bu sayfa üzerinden kontrol edilir.
  + **ShoppingCartPage:** Kullanıcı Sepeti Sayfasıdır.
