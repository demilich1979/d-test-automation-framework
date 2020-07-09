package diaceutics.selenium.models;

import lombok.Data;

@Data
public class User extends BaseModel {
    private String username;
    private String password;
}
