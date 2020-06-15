package aquality.template.restassured.framework;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void before(){
        RestAssured.requestSpecification = RequestSpecHelper.defaultSpec;
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
