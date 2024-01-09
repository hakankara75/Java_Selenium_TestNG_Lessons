package testNG_Tests.test.listeners;

import org.testng.Reporter;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_27_Listeners_Page;
import testNG_Tests.utilities.ConfigReader;

import static org.junit.Assert.assertTrue;
import static testNG_Tests.utilities.Driver.closeDriver;
import static testNG_Tests.utilities.Driver.getDriver;

public class Test05 {
    Selenium_TestNG_27_Listeners_Page page= new Selenium_TestNG_27_Listeners_Page();
    @Test
    public void testName() {

        /*
kullanici https://www.ktb.gov.tr/ sitesine gider
uygulamalar linki tiklanir
konusan kitaplik uygulamasini acar
konusan kitaplik uygulamasini actigini dogrular

 */
        //kullanici https://www.ktb.gov.tr/ sitesine gider
        Reporter.log("kullanici https://www.ktb.gov.tr/ sitesine gitti");
        getDriver().get(ConfigReader.getProperty("ktb"));

        //uygulamalar linki tiklanir
        page.uygulamalar.click();
        Reporter.log("kullanici uygulamalar linki tikladi");

        //konusan kitaplik uygulamasini acar
        page.konusanKitaplik.click();
        Reporter.log("kullanici konusan kitaplik uygulamasini acti");

        //konusan kitaplik uygulamasini actigini dogrular
        assertTrue(page.title.isDisplayed());
        Reporter.log("kullanici kitaplik uygulamasini actigini dogruladi");

        closeDriver();


    }
}
