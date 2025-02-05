package session;

import ebay.shopping.pages.CartPage;
import ebay.shopping.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class TestContext {

    private HomePage homePage;
    private CartPage cartPage;
    private WebDriver driver;
    private SoftAssert softAssert;

    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public void setCartPage(CartPage cartPage) {
        this.cartPage = cartPage;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public SoftAssert getSoftAssert() {
        return softAssert;
    }

    public void setSoftAssert(SoftAssert softAssert) {
        this.softAssert = softAssert;
    }
}
