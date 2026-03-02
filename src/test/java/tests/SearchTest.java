package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SearchTest {

    static AmazonPage amazonPage = new AmazonPage();
    static WebDriver driver = Driver.getDriver();

    public static void searchTest() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(2000);

            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }

        //Sayfadaki bütün listelenmiş ürünlerin isimlerini consola yazdır ve listeleme sayısın kaydet
        List<WebElement> allListings = driver.findElements(By.xpath("//h2[@class=\"a-size-base-plus a-spacing-none a-color-base a-text-normal\"]"));
        int count = 0;
        for ( WebElement productTitle : allListings ){
            count++;
            String title = productTitle.getText();
            System.out.println(count + "-" +title);
        }

        //Sayfaya spornsorlu olarak ekstra eklenen listelemeleri al
        List<WebElement> sponsoredListings = driver.findElements(By.xpath("//div[@class = \"a-row a-spacing-micro\"]"));

        //Listeleme sayıları karşılaştırılıyor
        int actualTitleCount = allListings.size();
        int expectedTitleCount = Integer.parseInt(ConfigReader.getProperty("expectedListing")) + sponsoredListings.size();

        assertEquals(actualTitleCount,expectedTitleCount);
    }
}
