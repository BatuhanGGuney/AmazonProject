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

import static org.testng.Assert.assertEquals;

public class AddToCardTest {

    static AmazonPage amazonPage = new AmazonPage();
    static WebDriver driver = Driver.getDriver();


    public static void addToCart() throws InterruptedException {

        //Fıyatı yüksekten düşüğe sırala
        amazonPage.arrangement.click();
        amazonPage.highToLow.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Fiyatı en yüksek olan ürünü sepete ekle
        amazonPage.addToCart.click();
        Thread.sleep(1000);

        //Fiyatı düşükten yükseğe sırala
        amazonPage.arrangement.click();
        new Actions(driver)
                .sendKeys(Keys.ARROW_UP)
                .sendKeys(Keys.ENTER)
                .perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(1000);

        //En düşük fiyatlı ürünü sepete ekle
        amazonPage.addToCart.click();
        Thread.sleep(1000);

        //Sepete git
        amazonPage.goToCart.click();

        List<WebElement> productsPrice = driver.findElements(By.xpath("//span[@class=\"a-price a-text-price sc-product-price sc-white-space-nowrap a-size-medium\"]"));
        double price = 0;
        int count = 0;
        for ( WebElement productprice : productsPrice ){
            count++;
            String priceText = productprice.getText()
                    .replaceAll("[^0-9,]", "")  // Sayı ve virgülü tut
                    .replace(",", ".");  // Virgülü noktaya çevir
            double priceD = Double.parseDouble(priceText);

            System.out.println(count + ". ürünün fiyatı : " + priceD + "TL");
            price = priceD + price;
        }
        System.out.println( "Ürünlerin fiyatlarının toplamı :" + price + "TL");

        double totalPrice = Double.parseDouble(amazonPage.totalPrice.getText()
                .replaceAll("[^0-9,]", "")  // Sayı ve virgülü tut
                .replace(",", "."));  // Virgülü noktaya çevir

        System.out.println("Sepetteki toplam fiyat : " + totalPrice + "TL");

        if(Math.abs(price - totalPrice) < 0.01){
            System.out.println("Toplam fiyat doğru hesaplanmış 👍");
        }
        assertEquals(price, totalPrice, "Toplam fiyat ürünlerin fiyatlarının toplamına eşit değil!");



    }
}
