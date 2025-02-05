package utilities;

import common.ExtentManager;
import common.StaticClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.time.Duration;
import java.util.Set;
import static common.StaticClass.*;
import static utilities.StaticUtility.formatNullToEmpty;

public class DriverUtil {

	protected WebDriver driver;
	protected SoftAssert softAssert;
	 
    public DriverUtil(WebDriver driver , SoftAssert softAssert){
        this.driver = driver;
        this.softAssert = softAssert;
    }

    public void clickTheElementWhenVisible(By locator , int timeOut){
        try {
            ExtentManager.logInfo(String.format(CLICKING_THE_ELEMENT , locator , timeOut));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.findElement(locator).click();
        }catch(StaleElementReferenceException | NoSuchElementException | TimeoutException e) {
            logFailAndTakeScreenShot(e.getMessage());
        }
    }

    public void clickTheElementWhenVisibleUsingJS(By locator , int timeOut){
        try {
            ExtentManager.logInfo(String.format(CLICKING_THE_ELEMENT , locator , timeOut));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement element = driver.findElement(locator);
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
            javascriptExecutor.executeScript("arguments[0].focus();",element);
            javascriptExecutor.executeScript("arguments[0].click();",element);
        }catch(StaleElementReferenceException | NoSuchElementException | TimeoutException e) {
            logFailAndTakeScreenShot(e.getMessage());
        }
    }

    public void logFailAndTakeScreenShot(String message){
        softAssert.assertTrue(false , message);
        ExtentManager.logFailAndAttachScreenshotAsBase64(takeScreenShotAsBase64() , message);
    }

    public void logPassAndTakeScreenshot(String message) {
        softAssert.assertTrue(true);
        ExtentManager.logPassAndTakeScreenshot(takeScreenShotAsFile() ,message);
    }

    public String takeScreenShotAsFile(){
        try{
            File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String source = StaticClass.SCREENSHOT_PATH + StaticUtility.timestamp() + ".jpg" ;
            File destinationFile = new File(source);
            FileUtils.copyFile(sourceFile , destinationFile);
            return destinationFile.getAbsolutePath();
        }catch (Exception e){
            return null;
        }
    }

    public String takeScreenShotAsBase64(){
        try{
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        }catch (Exception e){
            return null;
        }
    }

    public void sendKeysWhenVisible(By locator , String text , int timeOut){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement element = driver.findElement(locator);
            ExtentManager.logInfo(String.format(ENTERING_TEXT , text , locator));
            element.sendKeys(text);
        }catch(Exception e) {
            logFailAndTakeScreenShot(e.getMessage());
        }
    }

    public void switchToWindowBasedOnTitle(String title){
        Set<String> windowID = driver.getWindowHandles();
        for(String id : windowID ){
            String actualTitle = driver.switchTo().window(id).getTitle();
            if(actualTitle!=null && actualTitle.equals(title)){
                break;
            }
        }
    }

    public String getTextWhenVisible(By locator , int timeOut){
        try{
            WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement element = driver.findElement(locator);
            return element.getText();
        }catch (Exception e){
            logFailAndTakeScreenShot(e.getMessage());
        }
        return null;
    }

    public void verifyAttributeWhenVisible(By locator , String attribute , String expectedValue , int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            String actualValue = driver.findElement(locator).getDomAttribute(attribute);
            actualValue = formatNullToEmpty(actualValue);
            if(actualValue.equals(expectedValue)){
                logPassAndTakeScreenshot(String.format(EXPECTED_ATTRIBUTE_VALUE_WITH_LOCATION_MATCHING ,attribute , expectedValue , locator , timeOut));
            }else{
                logFailAndTakeScreenShot(String.format(EXPECTED_ATTRIBUTE_VALUE_WITH_LOCATION_NOT_MATCHING , attribute , expectedValue , locator , timeOut , actualValue));
            }
        }catch (Exception e){
            logFailAndTakeScreenShot(e.getMessage());
        }
    }




}
