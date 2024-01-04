package testNG_Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testNG_Tests.utilities.Driver;

public class Selenium_TestNG_25_DataProvider_Page {

    public Selenium_TestNG_25_DataProvider_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id="APjFqb")
    public WebElement searchBox;
    @FindBy(id="searchData")
    public WebElement n11SearchBox;
    @FindBy(id="username")
    public WebElement email;
    @FindBy(id="password")
    public WebElement password;
    @FindBy(xpath="//input[@name='login']")
    public WebElement login;
}
