package testNG_Tests.test.listeners;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_27_Listeners_Page;
import testNG_Tests.utilities.ConfigReader;

import static org.junit.Assert.*;
import static testNG_Tests.utilities.Driver.closeDriver;
import static testNG_Tests.utilities.Driver.getDriver;




@Listeners(testNG_Tests.utilities.Listeners.class)
public class Test01 {

    Selenium_TestNG_27_Listeners_Page page=new Selenium_TestNG_27_Listeners_Page();
    @Test
    public void pass() {

        getDriver().get(ConfigReader.getProperty("kitapYurdu"));

        String expectedTitle= "Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        String actualTitle= getDriver().getTitle();

        assertEquals(expectedTitle, actualTitle);

        closeDriver();

    }
    @Test
    public void fail() {

        getDriver().get(ConfigReader.getProperty("kitapYurdu"));

        assertFalse(page.logo.isDisplayed());

        closeDriver();
    }

    @Test
    public void skipTest() {

        System.out.println("Bu test skip edildi");
        throw new SkipException("Bu test skip edildi");

    }
}
