package diaceutics.selenium.models;

public class Platform extends BaseModel{

    private String platformManufacturer;
    private String platform;

    public String getPlatformManufacturer() {
        return platformManufacturer;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setPlatformManufacturer(String platformManufacturer) {
        this.platformManufacturer = platformManufacturer;
    }
}
