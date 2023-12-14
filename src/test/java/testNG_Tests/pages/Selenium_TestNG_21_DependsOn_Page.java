package testNG_Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testNG_Tests.utilities.Driver;

public class Selenium_TestNG_21_DependsOn_Page {

    public Selenium_TestNG_21_DependsOn_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id="link288732")
    public WebElement uygulamalar;
    @FindBy(id="link97181")
    public WebElement duyurular;
    @FindBy(id="link96254")
    public WebElement kulturSanat;
    @FindBy(css="a[href='/App/platform/1/Detail/55']")
    public WebElement konusanKitaplik;
}
