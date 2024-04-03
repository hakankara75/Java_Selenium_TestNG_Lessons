package testNG_Tests.test;

import com.github.pemistahl.lingua.api.Language;
import com.github.pemistahl.lingua.api.LanguageDetector;
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_29_Lingua_Language_Page;
import testNG_Tests.utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;
import static testNG_Tests.utilities.Driver.getDriver;

public class Selenium_TestNG_29_Lingua_Language {


    Selenium_TestNG_29_Lingua_Language_Page page = new Selenium_TestNG_29_Lingua_Language_Page();


    @Test
    public void lingua() {

        getDriver().get("https://tr.wikipedia.org/wiki/Anasayfa");

        String expected = "SPANISH";

        page.searchInput.sendKeys("Uygur Türkleri", Keys.ENTER);
        //page.searchButton.click();
        page.language.click();
        page.languageSearchBox.sendKeys(expected, Keys.ENTER);
        ReusableMethods.wait(2);
        page.languageList.click();


        String actualLanguage= getLanguage(page.text.getText());
        System.out.println("actualLanguage = " + actualLanguage);

        assertEquals(expected, actualLanguage);

    }

    public static String getLanguage(String string){
        LanguageDetector detector= LanguageDetectorBuilder
                .fromLanguages(Language.ENGLISH, Language.FRENCH, Language.GERMAN, Language.SPANISH, Language.TURKISH)
                .withMinimumRelativeDistance(0.1).build();

        Language detectLanguage = detector.detectLanguageOf(string);
        return detectLanguage.name();

    }
}
