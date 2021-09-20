package diaceutics.cucumber.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import diaceutics.selenium.models.User;
import diaceutics.selenium.utilities.ResourceUtil;
import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class DataReader {
    private final String USERS_FILE_RESOURCES_REL_PATH = "users.json";
    private final String USERS_FILE_RESOURCES_ABS_PATH = ResourceUtil.getResourcePath(USERS_FILE_RESOURCES_REL_PATH);

    public User getUserInfoByUserName(String userName) {
        String usersFileContent = FileProcessor.getFileContent(USERS_FILE_RESOURCES_ABS_PATH);
        Map<String, User> users = JsonObjectMapper.mapToObject(
                usersFileContent,
                new TypeReference<Map<String, User>>() {
                }
        );
        return users.get(userName);
    }
}
