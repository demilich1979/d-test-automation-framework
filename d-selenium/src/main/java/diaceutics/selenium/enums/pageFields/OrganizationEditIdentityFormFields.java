package diaceutics.selenium.enums.pageFields;

public enum OrganizationEditIdentityFormFields implements FormFieldInterface {
    TYPE("TYPE",
            "organization_edit_identity_organization_listingListingCategories",
            "type", FieldType.COMBOBOX),

    COMPANY_NAME("COMPANY NAME",
            "organization_edit_identity_organization_translations_en_title",
            "companyName",
            FieldType.TEXT),

    COUNTRY("COUNTRY",
            "organization_edit_identity_organization_contactAddress_country",
            "organizationCountry",
            FieldType.COMBOBOX),

    CITY("CITY",
            "organization_edit_identity_organization_contactAddress_city",
            "organizationCity",
            FieldType.TEXT),

    ZIP("ZIP",
            "organization_edit_identity_organization_contactAddress_zip",
            "organizationZip",
            FieldType.TEXT),

    STATE("STATE",
            "organization_edit_identity_organization_contactAddress_state",
            "organizationState",
            FieldType.TEXT),

    ADDRESS_STREET_NUMBER_AND_NAME("ADDRESS STREET NUMBER AND NAME",
            "organization_edit_identity_organization_contactAddress_address",
            "organizationAddressStreetNumberAndName",
            FieldType.TEXT);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;

    OrganizationEditIdentityFormFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static OrganizationEditIdentityFormFields getEnumValue(String friendlyName) {
        OrganizationEditIdentityFormFields organizationEditIdentityFormFields = null;
        for (OrganizationEditIdentityFormFields constant : OrganizationEditIdentityFormFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                organizationEditIdentityFormFields = constant;
                break;
            }
        }
        return organizationEditIdentityFormFields;
    }
}
