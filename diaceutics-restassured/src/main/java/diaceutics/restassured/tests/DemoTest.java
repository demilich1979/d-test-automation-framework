package diaceutics.restassured.tests;

import diaceutics.restassured.framework.BaseTest;
import diaceutics.restassured.framework.RequestSpecHelper;
import diaceutics.restassured.framework.RestRequestsHelper;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DemoTest extends BaseTest {

//    @Test
    public void demo(){
        Response response = RestRequestsHelper.getRequest("?version=latest");
        response.then().statusCode(200);
    }

//    @Test
    public void responseSpecPos(){
        ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
        RestRequestsHelper.getRequestWithResponseSpec(responseSpec,"?version=latest");
    }


    public void responseSpecNeg(){
        ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(201).build();
        RestRequestsHelper.getRequestWithResponseSpec(responseSpec,"?version=latest");
    }

//    @Test
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
//        assertThat(json, matchesJsonSchemaInClasspath("sample.json"));
    }
}
