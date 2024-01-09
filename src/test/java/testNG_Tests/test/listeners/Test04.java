package testNG_Tests.test.listeners;

import org.testng.SkipException;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_27_Listeners_Page;
import testNG_Tests.utilities.ConfigReader;

import static org.junit.Assert.*;
import static testNG_Tests.utilities.Driver.getDriver;

public class Test04 {
    Selenium_TestNG_27_Listeners_Page page=new Selenium_TestNG_27_Listeners_Page();

    @Test
    public void passTest() {
        getDriver().get(ConfigReader.getProperty("obilet"));

        assertTrue(page.obiletLogo.isDisplayed());

    }

    @Test
    public void failTest() {
        getDriver().get(ConfigReader.getProperty("obilet"));

        assertFalse(page.obiletLogo.isDisplayed());

    }
    @Test
    public void skipTest() {
        throw new SkipException("Bu test skip yapıldı");
    }
}
