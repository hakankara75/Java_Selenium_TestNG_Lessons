package testNG_Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testNG_Tests.utilities.Driver;

import java.util.List;

public class Selenium_TestNG_27_Listeners_Page {

    public Selenium_TestNG_27_Listeners_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css="img[title='kitapla buluşmanın en kolay yolu!']")
    public WebElement logo;
    @FindBy(id="search-words")
    public WebElement searchBox;
    @FindBy(xpath="//div[@class='header-main-start']")
    public WebElement obiletLogo;

    @FindBy(id="link288732")
    public WebElement uygulamalar;
    @FindBy(xpath="//a[@href='/App/platform/1/Detail/55']")
    public WebElement konusanKitaplik;
    @FindBy(xpath="//h4[@class='title mb-2']")
    public WebElement title;
    @FindBy(id="input-email")
    public WebElement email;
    @FindBy(id="input-password")
    public WebElement password;
    @FindBy(css="input[type='submit']")
    public WebElement loginButton;
    @FindBy(css="a[href='/dynamic_content?with_content=static']")
    public WebElement clickHere;
    @FindBy(xpath="//img[contains(@src,'/img/avatars/Original')]")
    public List<WebElement> images;
}
