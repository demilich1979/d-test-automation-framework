package diaceutics.selenium.enums.pageFields;

public enum RegisterPageFields implements FormFieldInterface {
    TYPE("Type", "user_registration_type", "type", FieldType.COMBOBOX),
    COMPANY_NAME("COMPANY NAME",
            "user_registration_organizationName",
            "companyName",
            FieldType.TEXT),

    FIRST_NAME_OF_THE_LEGAL_REPRESENTATIVE("FIRST NAME OF THE LEGAL REPRESENTATIVE",
            "user_registration_firstName",
            "firstNameOfTheLegalRepresentative",
            FieldType.TEXT),

    LAST_NAME_OF_THE_LEGAL_REPRESENTATIVE("LAST NAME OF THE LEGAL REPRESENTATIVE",
            "user_registration_lastName",
            "lastNameOfTheLegalRepresentative",
            FieldType.TEXT),

    EMAIL("EMAIL", "user_registration_email", "email", FieldType.TEXT),
    NEW_PASSWORD("NEW PASSWORD",
            "user_registration_plainPassword",
            "newPassword",
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


    RegisterPageFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static RegisterPageFields getEnumValue(String friendlyName) {
        RegisterPageFields registerPageFields = null;
        for (RegisterPageFields constant : RegisterPageFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                registerPageFields = constant;
                break;
            }
        }
        return registerPageFields;
    }
}
