package diaceutics.cucumber.hooks;

import diaceutics.cucumber.utilities.DataReader;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.models.User;
import io.cucumber.java.Before;

public class PropertyHooks {

    @Before(order = 1)
    public void getProperty() {
        User user = DataReader.getUserInfoByUserName("testUser");
        if (user.getPassword().trim().isEmpty()) {
            user.setPassword(System.getProperty("password"));
        }
        if (user.getUsername().trim().isEmpty()) {
            user.setPassword(System.getProperty("username"));
        }
        XmlFileStore.store("testUser", user);
    }
}
