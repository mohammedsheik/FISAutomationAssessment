package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.DriverUtil;

public class BasePage extends BaseLocators{

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected DriverUtil commonUtil;

    protected BasePage(WebDriver driver , SoftAssert softAssert){
        this.driver =  driver;
        this.softAssert = softAssert;
        this.commonUtil = new DriverUtil(driver , softAssert);
    }

    public static By getLocator(String locator , String value1) {
        return By.xpath(String.format(locator, value1));
    }

}
