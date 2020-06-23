package diaceutics.selenium.enums.pageFields;

public enum LabAddressPageFields implements FormFieldInterface {
    LOCATION_NAME("Location name", "Location name", "locationName", FieldType.TEXT),
    ADDRESS_ONE("Address 1", "Address 1", "addressOne", FieldType.TEXT),
    ADDRESS_TWO("Address 2", "Address 2", "addressTwo", FieldType.TEXT),
    CITY_TOWN("City / Town", "City / Town", "cityTown", FieldType.TEXT),
    REGION("Region", "Region", "region", FieldType.TEXT),
    COUNTRY("Country", "Country", "countryTwo", FieldType.COMBOBOX),
    POSTAL_CODE("Postal code", "Postal code", "postalCode", FieldType.TEXT);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;


    LabAddressPageFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static LabAddressPageFields getEnumValue(String friendlyName) {
        LabAddressPageFields labAddressPageFields = null;
        for (LabAddressPageFields constant : LabAddressPageFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                labAddressPageFields = constant;
                break;
            }
        }
        return labAddressPageFields;
    }
}
