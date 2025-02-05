package ebay.shopping.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CartPage extends BasePage {

    String CART_ICON_CLASS = "cart__icon";
    String CART_TOTAL_ITEMS_MESSAGE = "Your shopping cart contains %d items";

    public CartPage(WebDriver driver , SoftAssert softAssert) {
        super(driver , softAssert);
    }

    public void checkTotalCartItems(int total){
        String expected  = String.format(CART_TOTAL_ITEMS_MESSAGE , total);
        commonUtil.verifyAttributeWhenVisible(getLocator(CONTAINS_CLASS , CART_ICON_CLASS) , "aria-label" , expected , 20);
    }
}
