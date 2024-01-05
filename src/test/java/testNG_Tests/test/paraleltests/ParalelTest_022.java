package testNG_Tests.test.paraleltests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import testNG_Tests.utilities.ConfigReader;

public class ParalelTest_022 {

    @Test (groups = "faileTest")
    public void test() throws InterruptedException {

    WebDriver driverr = new EdgeDriver();

        driverr.get("https://tr.aliexpress.com/"); //istenen sayfaya gider

        Thread.sleep(2000);
        driverr.manage().window().maximize();

    WebElement id_SearchBox= driverr.findElement(By.id("search-words")); //id

    WebElement xpath_Bildirim_Izin_Ver= driverr.findElement(By.xpath("//div[@class=' _1-SOk']")); //xpath

    WebElement cssSelector_Alibaba_Uygulama_Indir= driverr.findElement(By.cssSelector("b[class='down-load-app--longStr--1OJgHfl")); //cssSelector

    //http://www.automationpractice.pl/index.php sitesine git
        driverr.navigate().to("http://www.automationpractice.pl/index.php");
    WebElement name_SearchBox= driverr.findElement(By.name("search_query")); //name

    WebElement className_SearchBox= driverr.findElement(By.className("search_query")); //className

    WebElement tagName_Header= driverr.findElement(By.tagName("header")); //tagName

    WebElement linkText_Contact_Us= driverr.findElement(By.linkText("Contact us")); //linkText
        Thread.sleep(3000);

        driverr.close();
}


    @Test
    public void softAssert() {
        /*
        SoftAssertion tüm assertionları yapıp en son doğrulama yapılmasına imkan verir.
        SoftAssertion son aşamaya kadar aradaki assertlerde hata olursa kod durmaz, sona kadar gider.
        Bu Hard assertion dan farkıdır.
        Yani 10 tane assertion yapılsa, arada hata da olsa kodlar durmaz en son 10. assertion da doğrulama yapıp sonucu gösterir.
        1- soft assertion objesi olustur
        2- soft assertion yap
        3- soft assertin parantezi icine aciklama metni yaz
        4- assertAll metodu calistir
        5- hata veren assert konsolda aciklama metni ile birlikte gorulur
         */
//kullanici https://www.bluerentalcars.com/ sitesine gider
        WebDriver drivere=new EdgeDriver();
        drivere.get(ConfigReader.getProperty("blueRentalAcar_Url"));
        drivere.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- soft assertion objesi olustur
        SoftAssert softAssert=new SoftAssert();

//         2- soft assertion yap
        String expectedTitle="Blue Rental ic, VIP Car Hire";
        String actualTitle= drivere.getTitle();
        softAssert.assertEquals(expectedTitle, actualTitle);

        WebElement continueReservation= drivere.findElement(By.xpath("//button[text()=' CONTINUE RESERVATION']"));
        softAssert.assertTrue(continueReservation.isDisplayed(), "Reservation butonu gorunur halde");

        String butonText= continueReservation.getText();
        softAssert.assertTrue(butonText.contains(" CONTINUE RESERVATIO"), "Reservation butonu texti  CONTINUE RESERVATION içeriyor");


//        3- assertAll metodu calistir. tum kodlar burada dogrulanir.
        softAssert.assertAll();
/*
soft assertion'un Hard assertion'dan farki onceki assertion fail verse bile java kodu durmaz.
tum assertionlar calisir. son soft assertion kodu ile dogrulama yapilip assertion islemi bitirilir.
 */
    }
}
