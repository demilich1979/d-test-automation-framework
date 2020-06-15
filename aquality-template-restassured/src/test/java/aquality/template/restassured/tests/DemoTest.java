package aquality.template.restassured.tests;

import aquality.template.restassured.framework.BaseTest;
import aquality.template.restassured.framework.RequestSpecHelper;
import aquality.template.restassured.framework.RestRequestsHelper;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class DemoTest extends BaseTest {

    @Test
    public void demo(){
        Response response = RestRequestsHelper.getRequest("?version=latest");
        response.then().statusCode(200);
    }

    @Test
    public void responseSpecPos(){
        ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
        RestRequestsHelper.getRequestWithResponseSpec(responseSpec,"?version=latest");
    }


    public void responseSpecNeg(){
        ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(201).build();
        RestRequestsHelper.getRequestWithResponseSpec(responseSpec,"?version=latest");
    }

    @Test
    public void setHeaders(){
        RequestSpecification rs = new RequestSpecHelper().getRequestSpec();
        rs.headers("my-sample-header", "Lorem ipsum dolor sit amet");
        Response response = RestRequestsHelper.getRequestWithRequestSpec(rs, "/headers");
        System.out.println(response.body().asString());
        response.then().body("headers.my-sample-header", equalTo("Lorem ipsum dolor sit amet"));
    }

    public void sampleJsonScheme(){
        RequestSpecification rs = new RequestSpecHelper().getRequestSpec();
        rs.headers("my-sample-header", "Lorem ipsum dolor sit amet");
        Response response = RestRequestsHelper.getRequestWithRequestSpec(rs, "/headers");
        String json = response.asString();
        assertThat(json, matchesJsonSchemaInClasspath("sample.json"));
    }
}
