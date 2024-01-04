package testNG_Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testNG_Tests.utilities.Driver;

import java.util.List;

public class Selenium_TestNG_24_Excel_Pages {
    public Selenium_TestNG_24_Excel_Pages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css="input#username")
    public WebElement email;
    @FindBy(css="input#password")
    public WebElement password;
    @FindBy(xpath="(//span[@class='mn-strong common-sprite'])[1]")
    public WebElement cokSatanKitaplar;
    @FindBy(xpath="(//a[@class='mn-icon icon-angleRight'])[2]")
    public WebElement cokSatanEdebiyatKitaplar;
    @FindBy(xpath="//div[@id='faceted-search-group-2']//div[@class='row']")
    public List<WebElement> yayinEvleri;
    @FindBy(xpath="//div[@class='name ellipsis']")
    public List<WebElement> kitapIsimleri;
}
