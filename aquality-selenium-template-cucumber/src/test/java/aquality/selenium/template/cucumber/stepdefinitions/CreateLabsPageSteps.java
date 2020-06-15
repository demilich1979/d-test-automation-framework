package aquality.selenium.template.cucumber.stepdefinitions;

import aquality.selenium.template.forms.pages.CreateLabPage;
import aquality.selenium.template.models.CreateLabInfo;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

public class CreateLabsPageSteps {

    private final CreateLabPage createLabPage;

    public CreateLabsPageSteps() {
        createLabPage = new CreateLabPage();
    }

    @Then("Create a Lab page is opened")
    public void cleckCreateLabPageIsOpened() {
        assertTrue(createLabPage.isDisplayed(), "Create a Lab page is opened");
    }

    @When("I fill first Create a Lab form using following data:")
     public void fillCreateLabPage(@Transpose CreateLabInfo createLabInfo) {
        createLabPage.setName(createLabInfo.getName());

    }

}
