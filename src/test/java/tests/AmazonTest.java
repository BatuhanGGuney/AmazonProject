package tests;

import org.testng.annotations.*;
import utilities.AmazonSetup;
import utilities.Driver;

public class AmazonTest {

    @BeforeTest
    public void setUp(){
        AmazonSetup.amazonSetup();
        AmazonSetup.acceptCookies();
    }

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
        Driver.quitDriver();
    }
}
