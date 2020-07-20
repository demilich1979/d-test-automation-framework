package diaceutics.selenium.enums.pageFields;

public enum UserEditIdentityFormFields implements FormFieldInterface {

    FIRST_NAME("FIRST NAME", "user_firstName", "firstName", FieldType.TEXT),
    LAST_NAME("LAST NAME", "user_lastName", "lastName", FieldType.TEXT),
    WEBSITE("WEBSITE", "user_website", "website", FieldType.TEXT),
    EMAIL("Email", "user_email", "email", FieldType.TEXT),
    PHONE("Phone", "user_phone", "phone", FieldType.TEXT),
    COUNTRY("Country", "user_billingAddress_country", "country", FieldType.COMBOBOX),
    CITY("CITY", "user_billingAddress_city", "city", FieldType.TEXT),
    ZIP("ZIP", "user_billingAddress_zip", "zip", FieldType.TEXT),
    STATE("STATE", "user_billingAddress_state", "state", FieldType.TEXT),
    ADDRESS_STREET_NUMBER_AND_NAME("ADDRESS STREET NUMBER AND NAME",
            "user_billingAddress_address",
            "addressStreetNumberAndName",
            FieldType.TEXT);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;


    UserEditIdentityFormFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static UserEditIdentityFormFields getEnumValue(String friendlyName) {
        UserEditIdentityFormFields userEditIdentityFormFields = null;
        for (UserEditIdentityFormFields constant : UserEditIdentityFormFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                userEditIdentityFormFields = constant;
                break;
            }
        }
        return userEditIdentityFormFields;
    }
}
