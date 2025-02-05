package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/GetBitCoinPriceAPI.feature",
        glue = {"stepdefinition","hooks"},
        tags = "@API and @BitcoinPriceAPI",
        plugin = {"html:test-output/CucumberAPITestReport.html"}
)

public class CucumberAPITestNGRunner extends AbstractTestNGCucumberTests {

}
