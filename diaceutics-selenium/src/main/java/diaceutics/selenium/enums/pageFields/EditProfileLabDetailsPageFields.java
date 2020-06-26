package diaceutics.selenium.enums.pageFields;

public enum EditProfileLabDetailsPageFields implements FormFieldInterface{
    COUNTRY("Country", "Country", "country", FieldType.COMBOBOX),
    NAME("Name", "Name", "name", FieldType.TEXT),
    URL("URL", "URL", "url", FieldType.TEXT),
    LAB_TYPE("Lab type", "Lab type", "labType", FieldType.RADIO);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;


    EditProfileLabDetailsPageFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static EditProfileLabDetailsPageFields getEnumValue(String friendlyName) {
        EditProfileLabDetailsPageFields editProfileLabDetailsPageFields = null;
        for (EditProfileLabDetailsPageFields constant : EditProfileLabDetailsPageFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                editProfileLabDetailsPageFields = constant;
                break;
            }
        }
        return editProfileLabDetailsPageFields;
    }
}
