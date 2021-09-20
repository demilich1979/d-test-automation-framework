package diaceutics.selenium.enums.pageFields;

public enum LocationOfTheCollaborationPageFields implements FormFieldInterface {
    COUNTRY("COUNTRY", "new_listing__step_two_location_country", "country", FieldType.COMBOBOX),
    CITY("CITY", "new_listing__step_two_location_city", "city", FieldType.TEXT),
    ZIP("ZIP", "new_listing__step_two_location_zip", "zip", FieldType.TEXT),
    NUMBER("NUMBER", "new_listing__step_two_location_street_number", "number", FieldType.TEXT),
    ROUTE("ROUTE", "new_listing__step_two_location_route", "route", FieldType.TEXT),
    ADDITIONAL_LOCATION_INFORMATION("Additional location information",
            "new_listing__step_two_location_additional_info",
            "additionalLocationInformation",
            FieldType.TEXT),

    I_ACCEPT_THE_TERMS_AND_CONDITIONS("I accept the Terms and Conditions",
            "new_listing__step_two_tac",
            "iAcceptTheTermsAndConditions",
            FieldType.CHECKBOX);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;

    LocationOfTheCollaborationPageFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static LocationOfTheCollaborationPageFields getEnumValue(String friendlyName) {
        LocationOfTheCollaborationPageFields descriptionOfTheCollaborationPageFields = null;
        for (LocationOfTheCollaborationPageFields constant : LocationOfTheCollaborationPageFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                descriptionOfTheCollaborationPageFields = constant;
                break;
            }
        }
        return descriptionOfTheCollaborationPageFields;
    }
}
