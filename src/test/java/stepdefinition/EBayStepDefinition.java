package stepdefinition;

import common.PropertyManager;
import factory.Factory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import session.TestContext;

import java.io.IOException;

public class EBayStepDefinition {

    TestContext testContext;
    WebDriver driver;
    SoftAssert softAssert;

    public EBayStepDefinition(TestContext testContext){
        this.testContext = testContext;
        driver = testContext.getDriver();
        softAssert = testContext.getSoftAssert();
    }

    @Given("The user navigates to {string} Home Page")
    public void theUserNavigatesToHomePage(String site) throws IOException {
        String url = PropertyManager.getPropertiesInstance().getProperty(site);
        testContext.getDriver().navigate().to(url);
    }

    @When("The user searches for a Book")
    public void the_user_searches_for_a_book() {
        testContext.setHomePage(Factory.getHomePage(driver , softAssert));
        testContext.getHomePage().searchProduct("Book");
    }

    @When("The user adds the first book to the cart")
    public void the_user_adds_the_first_book_to_the_cart() {
        testContext.getHomePage().addItemToTheCart(1);
    }

    @Then("The cart should reflect the updated number of items")
    public void the_cart_should_reflect_the_updated_number_of_items() {
        testContext.setCartPage(Factory.getCartPage(driver , softAssert));
        testContext.getCartPage().checkTotalCartItems(1);
    }

}
