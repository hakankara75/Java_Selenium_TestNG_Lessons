package testNG_Tests.test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_27_Listeners_Page;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static testNG_Tests.utilities.Driver.getDriver;

public class Selenium_TestNG_28_Image_Text_Test {
    Selenium_TestNG_27_Listeners_Page page= new Selenium_TestNG_27_Listeners_Page();

    @Test
    public void testName() {
        getDriver().get("https://the-internet.herokuapp.com/dynamic_content?with_content=static");
        BufferedImage firstImages= getImageData(page.images);
        System.out.println("firstImages = " + firstImages);

        page.clickHere.click();

        BufferedImage secondImages= getImageData(page.images);
        System.out.println("secondImages = " + secondImages);

        assertNotEquals(firstImages, secondImages);
        getDriver().close();
    }

    public BufferedImage getImageData(List<WebElement> element) {
        List<WebElement> images=element;
        BufferedImage image=null;
        for (int i = 0; i < images.size(); i++) {
            URL imageUrl=null;
            try{
             imageUrl=new URL(images.get(i).getAttribute("src"));
            }catch (MalformedURLException e)   {
                throw  new RuntimeException(e);
            }

            try {
                image= ImageIO.read(imageUrl);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int height= image.getHeight();
            System.out.println("height = " + height);
            int width= image.getWidth();
            System.out.println("width = " + width);

            String formateName=null;

            try {
                formateName=imageUrl.openConnection().getContentType();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("formateName = " + formateName);

        }
        return image;

    }

    @Test
    public void pageSource() {
        getDriver().get("https://the-internet.herokuapp.com/dynamic_content?with_content=static");

        String firstPageSource= getDriver().getPageSource();
        System.out.println("firstPageSource = " + firstPageSource);

        page.clickHere.click();

        String secondPageSource= getDriver().getPageSource();
        System.out.println("secondPageSource = " + secondPageSource);

        assertNotEquals(firstPageSource, secondPageSource);
        getDriver().close();
    }
}
