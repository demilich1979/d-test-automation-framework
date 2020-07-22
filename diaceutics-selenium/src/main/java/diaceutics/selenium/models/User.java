package diaceutics.selenium.models;

import lombok.Data;

@Data
public class User extends BaseModel {
    private String email;
    private String password;
    private String type;
    private String companyName;
    private String positionWithinTheOrganization;
    private String firstName;
    private String lastName;
    private String verification;
    private String website;
    private String country;
    private String city;
    private String zip;
    private String state;
    private String addressStreetNumberAndName;
    private String organizationCountry;
    private String organizationCity;
    private String organizationZip;
    private String organizationState;
    private String organizationAddressStreetNumberAndName;
    private String iAcceptTheTermsAndConditions;
    private String iAcceptThePrivacyPolicy;
}
