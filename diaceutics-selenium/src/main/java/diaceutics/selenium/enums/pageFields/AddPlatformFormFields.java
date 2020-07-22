package diaceutics.selenium.enums.pageFields;

public enum AddPlatformFormFields implements FormFieldInterface {
    PLATFORM_MANUFACTURER("Platform manufacturer",
            "//div[./label[text()='Platform manufacturer']]",
            "platformManufacturer",
            FieldType.COMBOBOX_JS),

    PLATFORM("Platform", "//div[./label[text()='Platform']]", "platform", FieldType.COMBOBOX_JS);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;

    AddPlatformFormFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
        this.friendlyName = friendlyName;
        this.locator = locator;
        this.modelField = modelField;
        this.fieldType = fieldType;
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

    public FieldType getFieldType() {
        return fieldType;
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
