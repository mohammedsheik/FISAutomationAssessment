package factory;

import ebay.shopping.pages.CartPage;
import ebay.shopping.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import java.io.IOException;


public class Factory {

    public static HomePage getHomePage(WebDriver driver , SoftAssert softAssert){
        return new HomePage(driver , softAssert);
    }

    public static CartPage getCartPage(WebDriver driver , SoftAssert softAssert){
        return new CartPage(driver , softAssert);
    }

    public static WebDriver getWebDriver() throws IOException {
        return DriverFactory.createDriver();
    }

    public static SoftAssert getSoftAssert(){
        return new SoftAssert();
    }

}
