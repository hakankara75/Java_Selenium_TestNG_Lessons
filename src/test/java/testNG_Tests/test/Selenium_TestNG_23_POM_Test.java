package testNG_Tests.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import testNG_Tests.pages.Selenium_TestNG_23_POM_Page;
import testNG_Tests.utilities.ConfigReader;
import testNG_Tests.utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;
import static testNG_Tests.utilities.Driver.closeDriver;
import static testNG_Tests.utilities.Driver.getDriver;

public class Selenium_TestNG_23_POM_Test {

    @Test
    public void pOModel() {


        // "https://www.obilet.com/" sitesine gidilir
        getDriver().get(ConfigReader.getProperty("obilet"));

        String expectedUrl= "https://www.obilet.com/";
        String actualUrl= getDriver().getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        closeDriver();

    }

    @Test
    public void positive() {
        Selenium_TestNG_23_POM_Page page=new Selenium_TestNG_23_POM_Page();
        //https://www.bluerentalcars.com/ sitesine gidilir
        getDriver().get(ConfigReader.getProperty("blue"));

        page.login.click();

        page.email.sendKeys(ConfigReader.getProperty("email"));
        page.password.sendKeys(ConfigReader.getProperty("password"));

        page.loginButton.click();
        ReusableMethods.wait(2);
        closeDriver();

    }
    @Test
    public void negative() {
        Selenium_TestNG_23_POM_Page page=new Selenium_TestNG_23_POM_Page();
        //https://www.bluerentalcars.com/ sitesine gidilir
        getDriver().get(ConfigReader.getProperty("blue"));

        page.login.click();

        page.email.sendKeys(ConfigReader.getProperty("emailFake"));
        page.password.sendKeys(ConfigReader.getProperty("passwordFake"));

        page.loginButton.click();
        ReusableMethods.wait(2);
        closeDriver();

    }



}
