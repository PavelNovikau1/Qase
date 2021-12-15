package adapters;

import io.restassured.response.ResponseBody;
import objects.TestSuite;

public class SuiteAdapter extends BaseAdapter{

    private static final String SUITE_URI = "/suite/%s";

    public int create(String projectCode, TestSuite testSuite) {
        return post(String.format(SUITE_URI, projectCode), converter.toJson(testSuite))
                .body().path("result.id");
    }

    public ResponseBody createDemo(String projectCode, TestSuite testSuite) {
        return post(String.format(SUITE_URI, projectCode), converter.toJson(testSuite))
                .body();
    }

    public void delete(String projectCode, int id) {
        delete(String.format(SUITE_URI + "/%S", projectCode, id));
    }
}