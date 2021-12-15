package adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BaseAdapter {

    private static final String TOKEN = "1ab078fbcf8806977c0764557e279901a47d3969";
    private static final String BASE_URL = "https://api.qase.io/v1";
    Gson converter = new Gson();

    public String get(String url) {
        return
                given()
                        .header("Token", TOKEN)
                        .header("Content-Type", "application/json")
                        .when()
                        .get(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().body().asString();
    }

    public Response post(String url, String body) {
        return
                given()
                        .header("Token", TOKEN)
                        .header("Content-Type", "application/json")
                        .body(body)
                        .when()
                        .post(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().response();
    }

    public void delete(String url) {
        given()
                .header("Token", TOKEN)
                .header("Content-Type", "application/json")
                .when()
                .delete(BASE_URL + url)
                .then()
                .log().all()
                .assertThat().body("status", equalTo(true));
    }
}
