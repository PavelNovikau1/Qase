package adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BaseAdapter {

    Gson converter = new Gson();

    public String get(String url) {
        return
                given()
                        .when()
                        .get(url)
                        .then()
                        .log().all()
                        .extract().body().asString();
    }

    public Response post(String url, String body) {
        return
                given()
                        .body(body)
                        .when()
                        .post(url)
                        .then()
                        .log().all()
                        .extract().response();
    }

    public Response delete(String url) {
        return
                given()
                        .when()
                        .delete(url)
                        .then()
                        .log().all()
                        .extract().response();
    }
}
