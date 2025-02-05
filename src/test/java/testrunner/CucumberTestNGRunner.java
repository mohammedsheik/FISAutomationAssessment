package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/EbayShoppingCart.feature",
        glue = {"stepdefinition","hooks"},
        publish = true,
        plugin = {"html:test-output/CucumberReports.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {

}
