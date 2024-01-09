package testNG_Tests.test.listeners;

import org.testng.SkipException;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_27_Listeners_Page;
import testNG_Tests.utilities.ConfigReader;

import static org.junit.Assert.*;
import static testNG_Tests.utilities.Driver.getDriver;

public class Test03 {
    Selenium_TestNG_27_Listeners_Page page= new Selenium_TestNG_27_Listeners_Page();

    @Test (retryAnalyzer = testNG_Tests.utilities.ListenersRetry.class)
    public void passTest() {
        getDriver().get(ConfigReader.getProperty("alibaba"));

        assertTrue(page.searchBox.isDisplayed());

    }

    @Test (retryAnalyzer = testNG_Tests.utilities.ListenersRetry.class)
    public void failTest() {
        getDriver().get(ConfigReader.getProperty("alibaba"));

        assertFalse(page.searchBox.isDisplayed());

    }

    @Test (retryAnalyzer = testNG_Tests.utilities.ListenersRetry.class)
    public void skipTest() {
        throw  new SkipException("Bu test atlandı");
    }

}
