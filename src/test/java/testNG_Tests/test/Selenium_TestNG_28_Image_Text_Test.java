package testNG_Tests.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_27_Listeners_Page;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;
import static testNG_Tests.utilities.Driver.getDriver;
import static testNG_Tests.utilities.ReusableMethods.compareImage;

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

    @Test
    public void pixelTest() {
        getDriver().get("https://www.ardahan.bel.tr/");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement siteImage= getDriver().findElement(By.xpath("(//img[@alt='Ardahan Belediyesi Logo'])[1]"));
        File expectedImageOriginal= new File(System.getProperty("user.home")+ "/Downloads/belediye-logo3.png");
        File expectedImageChanged= new File(System.getProperty("user.home")+ "/Downloads/hakan.png");

        URL imageUrl=null;
        BufferedImage actualImage=null;
        try {
            imageUrl=new URL(siteImage.getAttribute("src"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            actualImage=ImageIO.read(imageUrl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //bilgisayardan resmin okunup BufferedImage yapilmasi
        BufferedImage expectedImage;

        try {
            expectedImage=ImageIO.read(expectedImageOriginal);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        boolean isEqual=compareImage(expectedImage, actualImage);

        assertTrue("İki resim ayni degil",isEqual);
    }
}
