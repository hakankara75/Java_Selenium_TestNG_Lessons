package testNG_Tests.test;

public class Selenium_TestNG_27_FailTestRun_ListenersRetry_Test {

    /*
    FAİL OLAN TESTLERİ YENİDEN RUN ETMEK İÇİN YAPILACAKLAR
    A- @Test anatosyonu yanına kod veriler:
    1- utilities altına ListenersRetry açılır ve IRetryAnalyzer'a implements edilir
    2- Koşulacak class açılır.

    B- xml dosyası ile run etme
    1- utilities altına ListenersRetryAnalyzer açılır ve IAnnotationTransformer implements yapılır.
    2- Notasyon olmayan yeni bir class olarak Test04 açılır.
    3- Test04 üstünde sağ klik yapıp test05_Report_Listener.xml dosyasını oluştururuz.
    4- test05_Report_Listener.xml dosyasının ismini failTestRunner_Listener.xml yaptık
    5- dosyaının içine
    suite den sonra
 test'ten önce şu kod yapıştırılır:
     <listeners>
        <listener class-name="testNG_Tests.utilities.Listeners"/>
    </listeners>

    6- failTestRunner_Listener.xml dosyası içinden run çalıştırılır



     */
}
