package diaceutics.selenium.models;

import lombok.Data;

@Data
public class Lab extends BaseModel {
    private String name;
    private String country;
    private String url;
    private String labType;
    private String locationName;
    private String addressOne;
    private String addressTwo;
    private String cityTown;
    private String region;
    private String countryTwo;
    private String postalCode;
}
