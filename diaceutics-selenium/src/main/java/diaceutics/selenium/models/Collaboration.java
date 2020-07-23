package diaceutics.selenium.models;

import lombok.Data;

@Data
public class Collaboration extends BaseModel {
    //Description
    private String title;
    private String description;
    private String otherRequirements;
    private String type;
    //location
    private String country;
    private String city;
    private String zip;
    private String number;
    private String route;
    private String additionalLocationInformation;
    private String iAcceptTheTermsAndConditions;
}
