package testNG_Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testNG_Tests.utilities.Driver;

public class Selenium_TestNG_22_SoftAssertion_Page {

    public Selenium_TestNG_22_SoftAssertion_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css="button[type='submit']")
    public WebElement reservation;
}
