package ebay.shopping.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class HomePage extends BasePage {

    //Locators
    public String SEARCH_RESULTS =  "//ul[contains(@class,'srp-results')]";
    public String SEARCH_RESULT =  SEARCH_RESULTS + "/li[%s]";
    public String PRODUCT_TITLE =  SEARCH_RESULT + "//span[@role='heading']";

    //Constants
    public final String SEARCHTEXT = "Enter your search keyword";
    public final String ADDCARTTEXT = "Add to cart";

    public HomePage(WebDriver driver , SoftAssert softAssert) {
       super(driver, softAssert);
    }

    public void searchProduct(String searchText){
        commonUtil.sendKeysWhenVisible(getLocator(INPUT_BOX_WITH_LABEL , SEARCHTEXT) , searchText, 20);
        commonUtil.clickTheElementWhenVisible(getLocator(TEXT , "Search") , 20);
    }

    public void addItemToTheCart(int position){
        String productTitle = commonUtil.getTextWhenVisible(getLocator(PRODUCT_TITLE , String.valueOf(position)), 20);
        commonUtil.clickTheElementWhenVisible(getLocator(PRODUCT_TITLE , String.valueOf(position)), 20);
        commonUtil.switchToWindowBasedOnTitle(productTitle);
        commonUtil.clickTheElementWhenVisible(getLocator(TEXT , ADDCARTTEXT) , 20);
    }
}
