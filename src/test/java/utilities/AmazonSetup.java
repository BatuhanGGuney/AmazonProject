package utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.AmazonPage;

import java.time.Duration;

public class AmazonSetup {

    static AmazonPage amazonPage = new AmazonPage();

    public static void amazonSetup(){

        //Amazon sitesine giriş yap.
        Driver.getDriver().get(ConfigReader.getProperty("urlAmazon"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        try {
            if (amazonPage.cookies != null){
                amazonPage.acceptCookies.click();
            }
        } catch (NoSuchElementException e) {
            // çerez yoksa umrunda değil
        }

    }
}
