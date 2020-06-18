package diaceutics.cucumber.hooks;

import diaceutics.cucumber.utilities.SoftAssert;
import io.cucumber.java.After;

public class AssertHooks {

    @After(order = 2)
    public void assertAll() {
        SoftAssert.getInstance().assertAll();
        SoftAssert.getInstance().clear();
    }
}
