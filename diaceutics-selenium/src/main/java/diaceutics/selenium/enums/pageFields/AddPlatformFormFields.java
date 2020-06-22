package diaceutics.selenium.enums.pageFields;

public enum AddPlatformFormFields {
    PLATFORM_MANUFACTURER("Platform manufacturer", "Platform manufacturer", "platformManufacturer"),
    PLATFORM("Platform", "Platform", "platform");

    private final String friendlyName;
    private final String locator;
    private final String modelField;


    AddPlatformFormFields(String friendlyName, String locator, String modelField) {
        this.friendlyName = friendlyName;
        this.locator = locator;
        this.modelField = modelField;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public String getLocator() {
        return locator;
    }

    public String getModelField() {
        return modelField;
    }

    public static AddPlatformFormFields getEnumValue(String friendlyName) {
        AddPlatformFormFields addPlatformFormFields = null;
        for (AddPlatformFormFields constant : AddPlatformFormFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                addPlatformFormFields = constant;
                break;
            }
        }
        return addPlatformFormFields;
    }
}
