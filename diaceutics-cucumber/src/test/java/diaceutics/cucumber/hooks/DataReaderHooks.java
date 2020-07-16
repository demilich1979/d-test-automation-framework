package diaceutics.cucumber.hooks;

import diaceutics.cucumber.utilities.DataReader;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.models.User;
import io.cucumber.java.Before;

public class DataReaderHooks {

    @Before(order = 1)
    public void getUserInfo() {
        User adminUser = DataReader.getUserInfoByUserName("adminUser");
        User user = DataReader.getUserInfoByUserName("User");
        if (adminUser.getPassword().trim().isEmpty() || adminUser.getEmail().trim().isEmpty()) {
            adminUser.setPassword(System.getProperty("password"));
            adminUser.setPassword(System.getProperty("username"));
        }

        XmlFileStore.store("adminUser", adminUser);
        XmlFileStore.store("User", user);
    }
}
