package diaceutics.cucumber.runners;

import diaceutics.cucumber.objectfactory.CustomObjectFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/java/diaceutics/cucumber/features"},
        glue = {
                "diaceutics.cucumber.hooks",
                "diaceutics.cucumber.transformations",
                "diaceutics.cucumber.stepdefinitions"
        },
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm", "json:target/cucumber-reports/cucumber.json"},
        tags = {"@smoke"},
        strict = true,
        objectFactory = CustomObjectFactory.class
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
