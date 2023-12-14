package testNG_Tests.test;

import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_21_DependsOn_Page;
import testNG_Tests.utilities.ConfigReader;
import testNG_Tests.utilities.ReusableMethods;

import java.time.Duration;

import static testNG_Tests.utilities.Driver.closeDriver;
import static testNG_Tests.utilities.Driver.getDriver;

public class Selenium_TestNG_21_DependsOn_Test {
    Selenium_TestNG_21_DependsOn_Page page=new Selenium_TestNG_21_DependsOn_Page();

    @Test
    public void firstTest() {
        //kullanici https://www.ktb.gov.tr/ sitesine gider
        getDriver().get(ConfigReader.getProperty("ktb"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test(dependsOnMethods = "firstTest")
    public void second() {
        //uygulamalar linkini tiklar
        page.uygulamalar.click();
        ReusableMethods.wait(2);

    }

    @Test (dependsOnMethods = "second")
    public void third() {
        //konusan kitaplik uygulamasini acar
        page.konusanKitaplik.click();
        ReusableMethods.wait(2);

    }

    @Test(dependsOnMethods = "four")
    public void zTest() {
        //ana sayfaya gelir ve duyurular linkini tiklar
        page.kulturSanat.click();
        ReusableMethods.wait(2);

    }

    @Test(dependsOnMethods = "third")
    public void four() {
        //ana sayfaya gelir ve duyurular linkini tiklar
        getDriver().navigate().back();
        getDriver().navigate().back();
        //getDriver().get(ConfigReader.getProperty("kulturBakanligi"));
        page.duyurular.click();
        ReusableMethods.wait(2);
        closeDriver();
    }
}
