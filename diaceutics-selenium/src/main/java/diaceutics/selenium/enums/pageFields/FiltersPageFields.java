package diaceutics.selenium.enums.pageFields;

public enum FiltersPageFields implements FormFieldInterface{
    COUNTRY("Country", "Country", "country", FieldType.COMBOBOX),
    LAB_TYPE("Lab type", "Lab type", "labType", FieldType.RADIO);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;


    FiltersPageFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static FiltersPageFields getEnumValue(String friendlyName) {
        FiltersPageFields filtersPageFields = null;
        for (FiltersPageFields constant : FiltersPageFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                filtersPageFields = constant;
                break;
            }
        }
        return filtersPageFields;
    }
}
