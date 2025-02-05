package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/EbayShoppingCart.feature",
        glue = {"stepdefinition","hooks"},
        tags = "@UI and @eBayShoppingCart",
        publish = true,
        plugin = {"html:test-output/CucumberUITestReport.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class CucumberUITestNGRunner extends AbstractTestNGCucumberTests {

}
