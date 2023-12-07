package testNG_Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testNG_Tests.utilities.Driver;

public class Selenium_TestNG_16_Faker_FileExist_Page {
    public Selenium_TestNG_16_Faker_FileExist_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css="button#submitBTN")
    public WebElement signUp;
    @FindBy(id="password")
    public WebElement password;
    @FindBy(id="user_email")
    public WebElement email;
    @FindBy(id="phone")
    public WebElement phone;
    @FindBy(id="firstname")
    public WebElement firstName;
    @FindBy(id="last_name")
    public WebElement lastName;
    @FindBy(id="bs-select-1-2")
    public WebElement albania;
    @FindBy(css="div.recaptcha-checkbox-border")
    public WebElement captcha;
    @FindBy(css="div.filter-option-inner")
    public WebElement country;
    @FindBy(id="downloadButton")
    public WebElement download;

}
