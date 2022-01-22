# etstur
## Etstur Case Study
Etstur tarafından iletilen case çalışmasının 1. maddesi etsturcasestudy adlı klasörde yer almaktadır. Web Otomasyon Projesi Proje Page Object Model kullanılarak 
oluşturulmuş olup istenilen senaryonun koşumu tamamlanmıştır.
Projede io.github.bonigarcia.wdm.WebDriverManager kütüphanesinden yararlanılarak browser driverlarının projeye .exe dosyası olarak eklenmesi yerine 
driverların github üzerinden indirilerek açılması sağlanmıştır. 
Bu sayede driver sürümlerinden dolayı oluşacak hataların önüne geçilmesi sağlanmıştır. 
Test koşumu sırasında hata alındığında FailScreenShot dosyası altında ilgili tarih ve saat .jpeg dosyası  alınan ekran görüntüsünün adı olarak adlandırılmıştır. 
Assertionlar için Junit kütüphanesinden ve bekleme komutları için WaitTool kütüphanesinden yararlanılmıştır.
Proje Maven projesi olup Java dili ile Selenium frameworkundan yararlanılarak geliştirilmiştir.


Etstur Tarafından İstenilen Web Test Otomasyonu <br/>
İlk senaryomuzda senden www.etstur.com altındaki otel akışımız üzerinde otomatik bir test<br/>
süreci hazırlamanı istiyoruz. Kullanılacak test kütüphanesi: Selenium<br/>
Kullanılabilecek yazılım kütüphanesi: Java, Python<br/>
Hazırlayacağın test sürecinde aşağıdaki adımlarını takip etmeni bekliyoruz.<br/>
1 - Bir tarih aralığı ve bölge/tema belirleyerek arama yapman ve otel listelemesine ilerlemen<br/>
2 - Listelenen oteller arasından bir tanesi seçmen<br/>
3- Seçtiğin otelden bir oda seçimi yapman<br/>
4- Yaptığın oda seçiminin akabinde rezervasyon ve ödeme adımlarını doldurman<br/>
Ek notlar:<br/>
• Ödeme adımın kart bilgileri doldurma otomasyonun finalize edilmesi için yeterlidir.<br/>
• Bu akışın içinde bulunan bazı fail case’lerin de otomatize edilmesi de artı kabul edilir.<br/>

Test Stepleri<br/>
*Hotel Reservation Check Test Senaryosu
* www.etstur.com sitesi açılır.<br/>
* Kullanıcı login işlemleri gerçekleştirilir.<br/>
* Login sonrası dinamik olarak değiştirilebilen bölge ismine göre arama yapılarak uygun oteller listelenir.<br/>
* Kitap, müzik, Film, Hobi menü başlığı mause hover edilerek aşağıya doğru açılan menüde Çok Satanlar menü başlığına tıklanır.<br/>
* Listelenen otellerden listenin başında yer alan otel seçilir.<br/>
* Listelenen odalardan ilk oda seçilir.<br/>
* Kişi bilgileri doldurularak ödeme sayfasına geçilir<br/>
* Ödeme sayfasında yer alan Rezevasyon özetinde lokasyon bilgisi kontrol edilir ve ödeme bilgileri yanlış kart bilgileri doldurularak ilerlenir.<br/>
* Rezervasyonunuz tamamlanamadı mesajı görüldüğünde Screenshot alınarak otomasyon sonlandırılır<br/>

*Fail Senaryoları
* Login adımında Kullanıcı adı yanlış girilerek login butonuna tıklanır ve E-posta adresiniz sistemimizde kayıtlı değildir. Lütfen üyelik oluşturunuz. mesajı kontrol edilir.<br/>
* Login adımında Şifre yanlış girilerek login butonuna tıklanır ve Girdiğiniz şifre yanlış. Lütfen tekrar deneyin. mesajı kontrol edilir.<br/>
* Senayo içerisinde bölge Rotterdam seçilerek Arama kriterlerinize uygun bir sonuç bulunamadı. mesajı kontrol edilir.<br/>
* Kişi bilgileri doldurulmadan ödeme adımına ilerle butonuna tıklanır kişi bilgileri ile ilgili fail mesajları kontrol edilir<br/>
* Ödeme bilgileri doldurulmadan rezervasyonu tamamla butonuna tıklanır Ödeme bilgileri ile ilgili fail mesajları kontrol edilir<br/>
