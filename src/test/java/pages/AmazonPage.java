package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonPage {

    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy ( id = "sp-cc-headersss")
    public WebElement cookies;

    @FindBy ( id = "sp-cc-accept")
    public WebElement acceptCookies;

    @FindBy ( id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy ( xpath = "//*[@id=\"p_123/110955\"]/span/a/div/label/i")
    public WebElement appleTickBox;

    @FindBy ( xpath = "//*[@id=\"p_98/21345978031\"]/span/a/div/label/i")
    public WebElement amazonSendsTickBox;

    @FindBy ( className = "a-button-dropdown")
    public WebElement arrangement;

    @FindBy ( id = "s-result-sort-select_2")
    public WebElement highToLow;

    @FindBy ( name = "submit.addToCart")
    public WebElement addToCart;

    @FindBy ( xpath = "//span[@class=\"a-button a-button-span11 a-button-base a-button-small\"]")
    public WebElement goToCart;

    @FindBy ( xpath = "//span[@class=\"a-size-medium a-color-base sc-price sc-white-space-nowrap\"]")
    public WebElement totalPrice;
}
