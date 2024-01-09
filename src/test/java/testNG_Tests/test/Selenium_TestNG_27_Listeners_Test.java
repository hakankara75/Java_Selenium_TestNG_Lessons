package testNG_Tests.test;

public class Selenium_TestNG_27_Listeners_Test {
    /*

    LISTENERS
    1- utilities altında Listeners class açacağız
    2- bu classı ITestListener interface'ine implement yapacağız
    3-ITestListener interface'indeki metotları override yapacağız.

    Listeners 2 yolla çalışır:
    1- Listeners ile izlenecek olan class'ın hemen üstüne @Listeners(testNG_Tests.utilities.Listeners.class) eklenir.
    2- xml dosyası oluşturma:
    @Listeners(testNG_Tests.utilities.Listeners.class) notasyonu olmayan bir Test02 class açılır
    Test02 üstünde sağ klik yapılır. xml dosyası açılır
    failTestRunner_Listeners.xml dosyasının adı listeners_Test02.xml yapılır
    listeners_Test02.xml dosyası içine
 suite den sonra
 test'ten önce şu kod yapıştırılır:
     <listeners>
        <listener class-name="testNG_Tests.utilities.Listeners"/>
    </listeners>

     */
}
