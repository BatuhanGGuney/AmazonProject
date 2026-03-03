package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.AmazonSetup;
import utilities.Driver;

public class AmazonTest {

    @BeforeMethod
    public void searchIphone() throws InterruptedException {
        AmazonSetup.amazonSetup();

        SearchIphone.searchIphone();
    }

    @Test (priority = 1)
    public void searchTest() throws InterruptedException {
        SearchTest.searchTest();
    }

    @Test (priority = 2)
    public void addToCart() throws InterruptedException {
        AddToCardTest.addToCart();
    }

    @AfterTest
    public void tearDown(){
        Driver.closeDriver();
    }
}
