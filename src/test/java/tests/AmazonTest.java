package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTest {

    @BeforeMethod
    public void searchIphone() throws InterruptedException {
        SearchIphone.searchIphone();
    }

    @Test (priority = 1)
    public void searchTest() throws InterruptedException {
        SearchTest.searchTest();
    }

    @Test (priority = 2)
    public void addToCart() throws InterruptedException {
        addToCardTest.addToCart();
    }
}
