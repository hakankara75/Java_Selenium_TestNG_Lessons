package testNG_Tests.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class Driver {
     /*
        Driver class'ındaki temel mantık extends yöntemiyle değil yani ReusableMethods class'ına extent etmek yerine
    Driver class'ından static methodlar kullanarak driver oluştururuz. Static olduğu için class ismi ile
    her yerden methoda ulaşabileceğiz.
     */
    /*
    Singleton Pattern: Tekli kullanım kalıbı.
        Bir class'tan obje oluşturulmasının önüne geçilmesi için kullanılan ifade
        Bir class'tan obje oluşturmanın önüne geçmek için default constructor'ın kullanımını engellemek için
    private access modifire kullanarak bir constructor oluştururuz
     */

    private Driver(){
        /*
Singleton Pattern: Bir class'tan obje olusturulmasinin engellenmesidir.
Bunun icin class default constructor private yapildi.
 */
    }

    static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
                    ChromeOptions options= new ChromeOptions();
                    options.addArguments("--headless"); // Headless test yapmak icin
                    options.addArguments("--disaple-gpu"); //GPU kullanimini devre disi birakir
                    //driver= new ChromeDriver(options); //bu kodu headless testte acarsinizi
                    driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
                    break;
                case "edge":
                    driver= new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origins=*"));
                    break;
                default:
                    driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
return driver;
    }

    public static void  closeDriver(){
        if(driver !=null){ //Driver a deger atanmissa, calisiyorsa
            driver.close();
            driver = null;
        }
    }
    public static void  quiteDriver(){
        if(driver !=null){ //Driver a deger atanmissa, calisiyorsa
            driver.quit();
            driver = null;
        }
    }

}
