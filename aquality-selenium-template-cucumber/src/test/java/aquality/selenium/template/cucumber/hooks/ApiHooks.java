package aquality.selenium.template.cucumber.hooks;

import aquality.template.restassured.framework.RequestSpecHelper;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class ApiHooks {

    @Before(order = 1)
    public void before(){
        RestAssured.requestSpecification = RequestSpecHelper.defaultSpec;
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}

