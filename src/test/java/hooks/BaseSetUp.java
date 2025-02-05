package hooks;

import ebay.shopping.pages.HomePage;
import factory.Factory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import session.TestContext;

import java.io.IOException;

public class BaseSetUp {

    TestContext testContext;

    public BaseSetUp(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void initializeWebDriver() throws IOException {
        testContext.setDriver(Factory.getWebDriver());
    }

    @Before
    public void createSoftAssert() {
        testContext.setSoftAssert(Factory.getSoftAssert());
    }

    @After
    public void closeBrowser(){
        testContext.getDriver().quit();
    }

    @After
    public void assertAllErrors(){
        testContext.getSoftAssert().assertAll();
    }
}
