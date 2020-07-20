package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.SoftAssert;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.UserEditIdentityFormFields;
import diaceutics.selenium.models.User;
import diaceutics.selenium.pageobject.pages.MyProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class MyProfilePageSteps {

    private final MyProfilePage myProfilePage;

    public MyProfilePageSteps() {
        myProfilePage = new MyProfilePage();
    }

    @Then("MyProfile page is opened")
    public void myProfilePageIsOpened() {
        Assert.assertTrue(myProfilePage.isDisplayed(), "MyProfile page should be opened");
    }

    @And("Data for user {string} is displayed on the following fields on User Edit Identity Form on MyProfile page:")
    public void dataForUserAreDisplayedOnTheFollowingFieldsOnUserEditIdentityForm(String key, List<String> fields) {
        User user = XmlFileStore.get(key);
        fields.forEach(field -> {
            String actualValue = myProfilePage.getUserEditIdentityForm().getFieldValue(UserEditIdentityFormFields.getEnumValue(field));
            String expectedValue = user.getReflectionFieldValue(UserEditIdentityFormFields.getEnumValue(field).getModelField());
            SoftAssert.getInstance().assertEquals(
                    actualValue,
                    expectedValue,
                    String.format("Value for field %s is not correct on Identity form on MyProfile page", field));
        });
    }
}
