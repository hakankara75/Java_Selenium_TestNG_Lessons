package testNG_Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testNG_Tests.utilities.Driver;

public class Selenium_TestNG_23_POM_Page {
    public Selenium_TestNG_23_POM_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css="a[href='/login']")
    public WebElement login;
    @FindBy(id="formBasicEmail")
    public WebElement email;
    @FindBy(id="formBasicPassword")
    public WebElement password;
    @FindBy(css="button[class='btn btn-primary']")
    public WebElement loginButton;
}
