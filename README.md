# Etstur
## Etstur Case Study
Etstur tarafından iletilen case çalışmasının 1. maddesi etsturcasestudy adlı klasörde yer almaktadır.<br/> 
Proje Page Object Model kullanılarak oluşturulmuş olup istenilen senaryonun koşumu tamamlanmıştır.<br/> 
Projede io.github.bonigarcia.wdm.WebDriverManager kütüphanesinden yararlanılarak browser driverlarının projeye .exe dosyası olarak eklenmesi yerine driverların github üzerinden indirilerek açılması sağlanmıştır.<br/> 
Bu sayede driver sürümlerinden dolayı oluşacak hataların önüne geçilmesi sağlanmıştır.<br/> 
Test koşumu sırasında hata alındığında FailScreenShot dosyası altında ilgili tarih ve saat .jpeg dosyası  alınan ekran görüntüsünün adı olarak adlandırılmıştır.<br/> 
Assertionlar için Junit kütüphanesinden ve bekleme komutları için WaitTool kütüphanesinden yararlanılmıştır.<br/> 
Proje Maven projesi olup Java dili ile Selenium frameworkundan yararlanılarak geliştirilmiştir.<br/>
Projede dinamik olarak seçilebilir browser ve bölge adı yapısı kurulmuştur. İstenildiğinde firefox veya chrome browserında testler koşulabilir.<br/>

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
Hotel Reservation Check Test Senaryosu
* www.etstur.com sitesi açılır.<br/>
* Kullanıcı login işlemleri gerçekleştirilir.<br/>
* Login sonrası dinamik olarak değiştirilebilen bölge ismine göre arama yapılarak uygun oteller listelenir.<br/>
* Listelenen otellerden listenin başında yer alan otel seçilir.<br/>
* Listelenen odalardan ilk oda seçilir.<br/>
* Kişi bilgileri doldurularak ödeme sayfasına geçilir<br/>
* Ödeme sayfasında yer alan Rezevasyon özetinde lokasyon bilgisi kontrol edilir ve ödeme bilgileri yanlış kart bilgileri doldurularak ilerlenir.<br/>
* Rezervasyonunuz tamamlanamadı mesajı görüldüğünde Screenshot alınarak otomasyon sonlandırılır<br/>

Fail Senaryoları
* Login adımında Kullanıcı adı yanlış girilerek login butonuna tıklanır ve E-posta adresiniz sistemimizde kayıtlı değildir. Lütfen üyelik oluşturunuz. mesajı kontrol edilir.<br/>
* Login adımında Şifre yanlış girilerek login butonuna tıklanır ve Girdiğiniz şifre yanlış. Lütfen tekrar deneyin. mesajı kontrol edilir.<br/>
* Senayo içerisinde bölge Rotterdam seçilerek Arama kriterlerinize uygun bir sonuç bulunamadı. mesajı kontrol edilir.<br/>
* Kişi bilgileri doldurulmadan ödeme adımına ilerle butonuna tıklanır kişi bilgileri ile ilgili fail mesajları kontrol edilir<br/>
* Ödeme bilgileri doldurulmadan rezervasyonu tamamla butonuna tıklanır Ödeme bilgileri ile ilgili fail mesajları kontrol edilir<br/>

* Chrome'da Hotel Reservation Check Test Senaryosu<br/>
![chromeetstur](https://user-images.githubusercontent.com/92547323/150654658-cc7c2d39-06e1-4447-ab16-6aea32ae2967.gif)

* Chrome'da Ödeme Sayfası Hatalı Mesaj Kontrolleri<br/>
![paymentinformationfailmessages](https://user-images.githubusercontent.com/92547323/150654790-cea71d27-35c0-4bb4-869f-fe4de1a2a68f.gif)
