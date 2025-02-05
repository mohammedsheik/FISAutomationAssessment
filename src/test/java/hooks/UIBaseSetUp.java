package hooks;

import factory.Factory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.CucumberOptions;
import session.TestContext;

import java.io.IOException;

public class UIBaseSetUp {

    TestContext testContext;

    public UIBaseSetUp(TestContext testContext){
        this.testContext = testContext;
    }

    @Before("@UI")
    public void initializeWebDriver() throws IOException {
        testContext.setDriver(Factory.getWebDriver());
    }

    @Before("@UI")
    public void createSoftAssert() {
        testContext.setSoftAssert(Factory.getSoftAssert());
    }

    @After("@UI")
    public void closeBrowser(){
        testContext.getDriver().quit();
    }

    @After("@UI")
    public void assertAllErrors(){
        testContext.getSoftAssert().assertAll();
    }
}
