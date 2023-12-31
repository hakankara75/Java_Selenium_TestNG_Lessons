package testNG_Tests.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testNG_Tests.pages.Selenium_TestNG_22_SoftAssertion_Page;
import testNG_Tests.utilities.ConfigReader;

import java.time.Duration;

import static org.junit.Assert.*;
import static testNG_Tests.utilities.Driver.closeDriver;
import static testNG_Tests.utilities.Driver.getDriver;

public class Selenium_TestNG_22_SoftAssertion_Test {
    Selenium_TestNG_22_SoftAssertion_Page page= new Selenium_TestNG_22_SoftAssertion_Page();


    @Test
    public void softAssertion() {
//kullanici https://www.bluerentalcars.com/ sitesine gider
getDriver().get(ConfigReader.getProperty("blueRent"));
getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//1- Soft Assertion objesi oluştur
        SoftAssert softAssert=new SoftAssert();

        //2- soft assertion yaparız
        String expectedTitle="Blue Rental  VIP Car Hire";
        String actualTitle=getDriver().getTitle();
        softAssert.assertEquals(expectedTitle, actualTitle, "Bekelenen Title, gerçek title ile aynı");

        softAssert.assertTrue(page.reservation.isDisplayed(), "Reservation butonu görünür");

        String expectedReservationText=" CONTINUE RESERVATION";
        String actualReservationText= page.reservation.getText();
        System.out.println("actualReservationText = " + actualReservationText);
        softAssert.assertTrue(expectedTitle.equals(actualReservationText), "Reservation butonu üstündeki beklenen yazı, gerçek yazı ile aynı");

        //3.assertAll metodunu çalıştır. Tüm doğrulamaları bu adımda bitir.
        softAssert.assertAll();

        closeDriver();
    }

    @Test
    public void hardAssertions() {
        assertTrue("hakan".contains("hakan"));
        assertTrue(1==2);
        assertEquals(1,1);
        assertFalse("hakan".equals("kara"));
    }
}
