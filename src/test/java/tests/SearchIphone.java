package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

import static utilities.AmazonSetup.amazonSetup;

public class SearchIphone {
    static AmazonPage amazonPage = new AmazonPage();
    static WebDriver driver = Driver.getDriver();

    public static void searchIphone() throws InterruptedException {

        amazonSetup();

        //Arama kutusuna İphone yaz ve arat.
        WebElement searchBox = amazonPage.searchBox;
        searchBox.sendKeys(ConfigReader.getProperty("seachText"), Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(1000);

        //Filtrelerde markalar kısmında Apple ı ve amazon gönderiri seçiyoruz.
        amazonPage.appleTickBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(1000);
        amazonPage.amazonSendsTickBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(1000);
    }
}
