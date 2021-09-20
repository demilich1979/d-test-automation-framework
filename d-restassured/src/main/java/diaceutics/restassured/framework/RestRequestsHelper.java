package diaceutics.restassured.framework;

import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;

import static io.restassured.RestAssured.*;

public class RestRequestsHelper {

    /**
     * GET request with custom request specification
     * @param rs request specification
     * @param url endpoint url
     * @return response
     */
    public static Response getRequestWithRequestSpec(RequestSpecification rs, String url){
        return given().spec(rs).when().get(url).then().extract().response();
    }

    /**
     * GET request with custom response specification
     * @param rs response specification
     * @param url endpoint url
     * @return response
     */
    public static Response getRequestWithResponseSpec(ResponseSpecification rs, String url){
        return given().when().get(url).then().spec(rs).extract().response();
    }

    /**
     * GET request with custom request specification and some cookie
     * @param rs request specification
     * @param url endpoint url
     * @param cookie custom cookie
     * @return response
     */
    public static Response getWithCookie(RequestSpecification rs, String url, Cookie cookie){
        return given().spec(rs).cookie(cookie).when().get(url).then().extract().response();
    }

    /**
     * GET request
     * @param url endpoint url
     * @return response
     */
    public static Response getRequest(String url){
        return given().when().get(url).then().extract().response();
    }

    /**
     * POST request
     * @param url endpoint url
     * @param object request body
     * @return response
     */
    public static Response postRequest(String url, Object object){
        return given().body(object).when().post(url).then().extract().response();
    }

    /**
     * Upload file, text etc.
     * @param url endpoint url
     * @param filepath path to a file
     * @return response
     */
    public static Response sendMultiPartFormData(String url, String filepath){
        return given().multiPart(new File(filepath)).when().post(url).then().extract().response();
    }

    /**
     * PUT request
     * @param url endpoint url
     * @param object request body
     * @return response
     */
    public static Response putRequest(String url, Object object){
        return given().body(object).when().put(url).andReturn();
    }

    /**
     * DELETE request
     * @param url endpoint url
     * @return response
     */
    public static Response deleteRequest(String url){
        return given().when().delete(url).andReturn();
    }
}
