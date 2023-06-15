package step_definitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static com.google.common.base.Predicates.equalTo;

public class GETStepdefs {
    @Steps
    WeatherAPI weatherAPI;

    @Given("^User Set Paramater API Current Weather$")
    public void userSetParamaterAPICurrentWeather() {
        SerenityRest.given().get(WeatherAPI.GET_CURRENT);
    }

    @Then("Status Code Should be {int} OK")
    public void statusCodeShouldBeOK(int page) {
        SerenityRest.then().statusCode(page);
    }

    @And("^Validate GET Current Weather json schema$")
    public void validateGETCurrentWeatherJsonSchema() {
        File jsonSchemaValidator = new File(WeatherAPI.JSON_SCHEMA_VALIDATOR + "/GetCurrentSchemaValidator.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaValidator));
    }

    @Given("^Set Paramater Forecast Weather$")
    public void setParamaterForecastWeather() {
        SerenityRest.given().get(WeatherAPI.GET_FORERCAST);
    }

    @And("^Validate GET forecast Weather json schema$")
    public void validateGETForecastWeatherJsonSchema() {
        File jsonSchemaValidator = new File(WeatherAPI.JSON_SCHEMA_VALIDATOR + "/GetForecastSchemaValidator.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaValidator));

    }
}
