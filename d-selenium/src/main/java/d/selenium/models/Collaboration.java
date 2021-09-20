package diaceutics.selenium.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Collaboration extends BaseModel {
    //Description
    private String title;
    private String description;
    private String otherRequirements;
    private String type;
    //media
    private String youtubeUrl;
    //location
    private String country;
    private String city;
    private String zip;
    private String number;
    private String route;
    private String additionalLocationInformation;
    private String iAcceptTheTermsAndConditions;
}
