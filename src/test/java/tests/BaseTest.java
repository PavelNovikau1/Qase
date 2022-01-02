package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;
import static io.restassured.RestAssured.given;

public abstract class BaseTest {

    @BeforeMethod
    public void configureRestAssured() {
        RestAssured.baseURI = "https://api.qase.io/v1";
        RestAssured.requestSpecification = given()
                .header("token", System.getProperty("token", PropertyReader.getProperty("token")))
                .contentType(ContentType.JSON).accept(ContentType.JSON);
    }
}
