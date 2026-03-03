package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AmazonPage;

import java.time.Duration;

public class AmazonSetup {

    static AmazonPage amazonPage = new AmazonPage();

    public static void amazonSetup(){

        //Amazon sitesine giriş yap.
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("urlAmazon"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(amazonPage.acceptCookies)).click();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Cookies popup bulunamadı, devam ediliyor...");
        }

    }
}
