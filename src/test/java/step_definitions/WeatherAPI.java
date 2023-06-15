package step_definitions;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class WeatherAPI {
    public static final String URL = "https://api.weatherbit.io/v2.0";
    public static final String DIR = System.getProperty("user.dir");

    public static final String JSON_SCHEMA_VALIDATOR = DIR + "/src/test/resources/JSONSchemaValidator";

    public static final String GET_CURRENT = URL + "/current?lat=40.730610&lon=-73.935242&key=47b59baa393a4264b0a2604e6892ef87";
    public static final String GET_FORERCAST = URL + "/forecast/daily?postal_code=16620&key=47b59baa393a4264b0a2604e6892ef87";


}
