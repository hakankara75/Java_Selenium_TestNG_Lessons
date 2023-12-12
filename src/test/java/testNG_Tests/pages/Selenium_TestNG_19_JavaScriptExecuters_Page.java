package testNG_Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testNG_Tests.utilities.Driver;

public class Selenium_TestNG_19_JavaScriptExecuters_Page {

    public Selenium_TestNG_19_JavaScriptExecuters_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css="a[class='btn btn-black navbar-btn']")
    public WebElement register;
    @FindBy(id="username")
    public WebElement mail;
    @FindBy(id="password")
    public WebElement password;
    @FindBy(id="log-in")
    public WebElement sign;
    @FindBy(css="h2[class='journals__title']")
    public WebElement yayinlar;
    @FindBy(css="a[href='https://beyazmasa.ibb.istanbul/application/beyazmasa']")
    public WebElement yuzelliuc;
    @FindBy(xpath="(//i[@class='fal fa-search'])[4]")
    public WebElement aramaButonu;
    @FindBy(xpath="(//i[@class='fal fa-search'])[5]")
    public WebElement aramaButonu2;
    @FindBy(xpath="//input[@placeholder='Sitede ara...']")
    public WebElement aramaKutusu;
    @FindBy(id="newsletter-input")
    public WebElement newsletter;

}
