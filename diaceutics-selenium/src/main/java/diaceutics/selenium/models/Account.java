package diaceutics.selenium.models;

import lombok.Data;

@Data
public class Account extends BaseModel {
    private String type;
    private String companyName;
    private String firstNameOfTheLegalRepresentative;
    private String lastNameOfTheLegalRepresentative;
    private String email;
    private String newPassword;
    private String verification;
    private String iAcceptTheTermsAndConditions;
    private String iAcceptThePrivacyPolicy;
}
