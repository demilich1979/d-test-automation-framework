package diaceutics.restassured.framework;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecHelper {
    private static final String DEFAULT_URI = "http://postman-echo.com/";
    private RequestSpecification spec;

    public static RequestSpecification defaultSpec = new RequestSpecBuilder().log(LogDetail.URI).setBaseUri(DEFAULT_URI).setContentType(ContentType.ANY).build();

    /**
     * Get custom request specification
     * @return request specification
     */
    public RequestSpecification getRequestSpec() {
        if (spec == null)
            spec = RestAssured.given().spec(new RequestSpecBuilder().setBaseUri(DEFAULT_URI).build());
        return spec;
    }
}
