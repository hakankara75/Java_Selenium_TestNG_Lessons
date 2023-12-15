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
    Selenium_TestNG_22_SoftAssertion_Page page=new Selenium_TestNG_22_SoftAssertion_Page();

    @Test
    public void hardAssertions() {
        assertTrue(1==1);
        assertTrue("Hakan".equals("Yusuf"));
        assertTrue("Hakan".contains("Hakan"));
        assertFalse(1==3);
        assertFalse("Hakan".equals("Kamil"));
        assertEquals("Hakan","Hakan");

    }

    @Test
    public void softAssertions() {
        //kullanici https://www.bluerentalcars.com/ sitesine gider
        getDriver().get(ConfigReader.getProperty("blue"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. soft assrtion objesi olustur
        SoftAssert softAssert=new SoftAssert();

        //2. soft assetion ile dogrulama yap
        String expectedTitle="Blue Rental Cars | Cheap, Hygienic, VIP Car Hire";
        String actualTitle=getDriver().getTitle();
        softAssert.assertEquals(expectedTitle, actualTitle);


        softAssert.assertTrue(page.reservation.isDisplayed());

        softAssert.assertTrue(page.brand.isDisplayed());

        //assertAll ile bitir. Tum kodlar burada dogrulanacak.
        softAssert.assertAll();
        closeDriver();

    }
}
