package testNG_Tests.test.listeners;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_27_Listeners_Page;
import testNG_Tests.utilities.AllureReportListener;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static testNG_Tests.utilities.Driver.getDriver;
@Listeners({AllureReportListener.class})
public class Failed_Followed_With_Alure {

    Selenium_TestNG_27_Listeners_Page page=new Selenium_TestNG_27_Listeners_Page();

    @Test
    @Description("Bu test valid data ile login dener")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Kullanici valid data ile login menusune girer")
    @Step("Kullanici lambdatest sitesine giris yapar")
    public void testName() {
        getDriver().get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        page.email.sendKeys("hakanbatirhan@gmail.com");
        page.password.sendKeys("453246324");
        page.loginButton.click();

        String expectedUrl="https://ecommerce-playground.lambdatest.io/index.php?route=account/account";
        String actualUrl=getDriver().getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

    }
}
