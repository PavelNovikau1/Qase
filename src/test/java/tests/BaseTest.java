package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.given;

public abstract class BaseTest {

    private static final String TOKEN = "1ab078fbcf8806977c0764557e279901a47d3969";

    @BeforeMethod
    public void configureRestAssured() {
        RestAssured.baseURI = "https://api.qase.io/v1";
        RestAssured.requestSpecification = given()
                .header("Token", TOKEN)
                .contentType(ContentType.JSON).accept(ContentType.JSON);
    }
}
