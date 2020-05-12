package hw_rest_assured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class YandexSpellerService {

    public RequestSpecification requestSpec;

    public YandexSpellerService() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(PropertyReader.readProp("baseUri"))
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        return given(requestSpec)
                .params(params)
                .when()
                .get(uri);
    }
}
