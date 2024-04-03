package testNG_Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testNG_Tests.utilities.Driver;

import java.util.List;

public class Selenium_TestNG_29_Lingua_Language_Page {

    public Selenium_TestNG_29_Lingua_Language_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id="searchInput")
    public WebElement searchInput;
    @FindBy(css=".cdx-button.cdx-search-input__end-button")
    public WebElement searchButton;
    @FindBy(id="p-lang-btn-checkbox")
    public WebElement language;
    @FindBy(css="div[class='uls-lcd-region-section'] ul[class='three columns']")
    public WebElement languageList;
    @FindBy(css="input[placeholder='Bir dil arayın']")
    public WebElement languageSearchBox;
    @FindBy(css="body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > main:nth-child(1) > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > p:nth-child(3)")
    public WebElement text;

}
