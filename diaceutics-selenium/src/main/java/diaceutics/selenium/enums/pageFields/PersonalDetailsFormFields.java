package diaceutics.selenium.enums.pageFields;

public enum PersonalDetailsFormFields implements FormFieldInterface {
    TYPE("Type", "user_registration_type", "type", FieldType.COMBOBOX),
    COMPANY_NAME("COMPANY NAME",
            "user_registration_organizationName",
            "companyName",
            FieldType.TEXT),

    FIRST_NAME_OF_THE_LEGAL_REPRESENTATIVE("FIRST NAME OF THE LEGAL REPRESENTATIVE",
            "user_registration_firstName",
            "firstName",
            FieldType.TEXT),

    POSITION_WITHIN_THE_ORGANIZATION("POSITION WITHIN THE ORGANIZATION",
            "user_registration_profession",
            "positionWithinTheOrganization",
            FieldType.TEXT),

    LAST_NAME_OF_THE_LEGAL_REPRESENTATIVE("LAST NAME OF THE LEGAL REPRESENTATIVE",
            "user_registration_lastName",
            "lastName",
            FieldType.TEXT),

    EMAIL("EMAIL", "user_registration_email", "email", FieldType.TEXT),
    NEW_PASSWORD("NEW PASSWORD",
            "user_registration_plainPassword",
            "password",
            FieldType.TEXT),

    VERIFICATION("VERIFICATION",
            "user_registration_plainPasswordConfirmation",
            "verification", FieldType.TEXT),

    I_ACCEPT_THE_TERMS_AND_CONDITIONS("I accept the Terms and Conditions",
            "//label[@for='user_registration_tac']",
            "iAcceptTheTermsAndConditions", FieldType.CHECKBOX),

    I_ACCEPT_THE_PRIVACY_POLICY("I accept the Privacy Policy",
            "//label[@for='user_registration_rgpd']",
            "iAcceptThePrivacyPolicy", FieldType.CHECKBOX);


    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;

    PersonalDetailsFormFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static PersonalDetailsFormFields getEnumValue(String friendlyName) {
        PersonalDetailsFormFields personalDetailsFormFields = null;
        for (PersonalDetailsFormFields constant : PersonalDetailsFormFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                personalDetailsFormFields = constant;
                break;
            }
        }
        return personalDetailsFormFields;
    }
}
