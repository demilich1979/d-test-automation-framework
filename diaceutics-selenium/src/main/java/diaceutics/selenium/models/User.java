package diaceutics.selenium.models;

import lombok.Data;

@Data
public class User extends BaseModel {
    private String username;
    private String password;
    private String type;
    private String companyName;
    private String firstNameOfTheLegalRepresentative;
    private String lastNameOfTheLegalRepresentative;
    private String verification;
    private String iAcceptTheTermsAndConditions;
    private String iAcceptThePrivacyPolicy;
}
