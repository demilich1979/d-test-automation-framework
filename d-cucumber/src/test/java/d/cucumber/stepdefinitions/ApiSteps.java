package diaceutics.cucumber.stepdefinitions;

import diaceutics.restassured.tests.DemoTest;
import io.cucumber.java.en.Given;

public class ApiSteps {

    private final DemoTest demoTest;

    public ApiSteps() {
        demoTest = new DemoTest();
    }

    @Given("Start Demo test")
    public void startDemoTest() {
        demoTest.demo();
    }

    @Given("Start responseSpecPos test")
    public void startResponseSpecPosTest() {
        demoTest.responseSpecPos();
    }

    @Given("Start setHeaders test")
    public void startSetHeadersTest() {
        demoTest.setHeaders();
    }

}
