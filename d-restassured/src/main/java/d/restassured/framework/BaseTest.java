package diaceutics.restassured.framework;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class BaseTest {
    static void before(){
        RestAssured.requestSpecification = RequestSpecHelper.defaultSpec;
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
