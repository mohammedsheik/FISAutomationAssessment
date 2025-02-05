package stepdefinition;


import common.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.*;

public class BitCoinAPIStepDefinition {

    RequestSpecification requestSpecification;
    Response response;

    @Given("Given The Bitcoin price API is configured and ready for requests")
    public void given_the_bitcoin_price_api_is_configured_and_ready_for_requests() throws IOException {
        String baseURI = PropertyManager.getPropertiesInstance().getProperty("BPI_API_URI");
        requestSpecification = new RequestSpecBuilder().setBaseUri(baseURI).build();
    }

    @When("GET request is sent to the Bitcoin price endpoint")
    public void get_request_is_sent_to_the_bitcoin_price_endpoint() throws IOException {
        String endpoint = PropertyManager.getPropertiesInstance().getProperty("BPI_API_GET_PRICE_ENDPOINT");
        response = RestAssured.given().log().all().spec(requestSpecification).when().get(endpoint).then().log().all().extract().response();
    }

    @Then("The response should have the BPI")
    public void the_response_should_have_the_bpi(io.cucumber.datatable.DataTable dataTable) {
       Set<String> expectedCurrency = new HashSet<>(dataTable.asList(String.class));
       JsonPath jsonPath = new JsonPath(response.asString());
       Map<String,Object> map = jsonPath.getMap("bpi");
       Set<String> actualCurrency = map.keySet();
       Assert.assertEquals(expectedCurrency , actualCurrency , "Currency in the BPI is not matching");
    }

    @And("The {string} description equals {string}")
    public void theDescriptionEquals(String currency, String description) {
        JsonPath jsonPath = new JsonPath(response.asString());
        String actualDescription= jsonPath.get("bpi."+currency+".description");
        Assert.assertEquals(description , actualDescription);
    }
}
