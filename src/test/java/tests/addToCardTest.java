package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AmazonPage;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class addToCardTest {

    static AmazonPage amazonPage = new AmazonPage();
    static WebDriver driver = Driver.getDriver();

    public static void addToCart() throws InterruptedException {

        //Fıyatı yüksekten düşüğe sırala
        amazonPage.arrangement.click();
        amazonPage.highToLow.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Fiyatı en yüksek olan ürünü sepete ekle
        amazonPage.addToCart.click();
        Thread.sleep(2000);

        //Fiyatı düşükten yükseğe sırala
        amazonPage.arrangement.click();
        new Actions(driver)
                .sendKeys(Keys.ARROW_UP)
                .sendKeys(Keys.ENTER)
                .perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(2000);

        //En düşük fiyatlı ürünü sepete ekle
        amazonPage.addToCart.click();
        Thread.sleep(2000);

        //Sepete git
        amazonPage.goToCart.click();

        List<WebElement> productsPrice = driver.findElements(By.xpath("//span[@class=\"a-price a-text-price sc-product-price sc-white-space-nowrap a-size-medium\"]"));
        double price = 0;
        for ( WebElement productprice : productsPrice ){
            String priceText = productprice.getText();
            priceText = priceText.replace(",00TL","");
            priceText = priceText.replace(".","");
            //priceText = priceText.replace(",","");
            double priceD = Double.parseDouble(priceText);
            System.out.println(priceD);
            price = priceD + price;
        }
        System.out.println(price);
    }
}
