package utilities;

import org.openqa.selenium.WebDriver;
import pages.AmazonPage;
import java.time.Duration;

public class AmazonSetup {

    static AmazonPage amazonPage = new AmazonPage();

    public static void amazonSetup(){

        //Amazon sitesine giriş yap.
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("urlAmazon"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    public static void  acceptCookies(){
        try {
            amazonPage.acceptCookies.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Cookies popup bulunamadı, devam ediliyor...");
        }
    }
}
