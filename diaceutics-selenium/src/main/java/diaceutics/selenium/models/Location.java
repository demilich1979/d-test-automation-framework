package diaceutics.selenium.models;

import lombok.Data;

@Data
public class Location extends BaseModel {
    private String locationName;
    private String addressOne;
    private String addressTwo;
    private String cityTown;
    private String region;
    private String country;
    private String postalCode;
}
