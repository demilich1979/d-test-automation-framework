package diaceutics.selenium.enums.pageFields;

public enum LabMappingResultsFormFields implements FormFieldInterface {
    NAME("Name", "name", "assayName", FieldType.TEXT),
    DESCRIPTION("Description", "description", "assayDescription", FieldType.TEXT),
    BIOMARKER("Biomarkers", "readableBiomarkers", "biomarkers", FieldType.TEXT),
    WHERE_IS_IT_PERFORMED("Where is it performed?", "readableSendout", "inHouseOrSendOut", FieldType.TEXT),
    SEND_OUT_LAB("Send-out Lab", "sendOutLabName", "sendOutLab", FieldType.TEXT),
    DETECTS("Detects Germline/Somatic alterations", "readableDetectGermlineSomatics", "detects", FieldType.TEXT),
    SPECIMENS_TESTED("Specimens tested", "2", "specimensTested", FieldType.TEXT),
    METHOD("Method", "readableMethod", "method", FieldType.TEXT),
    METHOD_DESCRIPTION("Method description", "methodDescription", "methodDescription", FieldType.TEXT),
    COMMERCIAL_ASSAYS("Commercial Assays", "readableCommercialAssay", "commercialAssays", FieldType.TEXT),
    CLASSIFICATION("Classification", "3", "classifications", FieldType.TEXT),
    TURN_AROUND_TIME("Turnaround Time", "readableTat", "turnAroundTime", FieldType.TEXT),
    ONTOLOGY("Ontology", "4", "ontology", FieldType.TEXT),
    SENSITIVITY("Sensitivity", "readableSensitivity", "sensitivity", FieldType.TEXT),
    RESULT_FORMAT("Result Format", "readableResultFormat", "resultFormat", FieldType.TEXT);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;

    LabMappingResultsFormFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static LabMappingResultsFormFields getEnumValue(String friendlyName) {
        LabMappingResultsFormFields labMappingResultsFormFields = null;
        for (LabMappingResultsFormFields constant : LabMappingResultsFormFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                labMappingResultsFormFields = constant;
                break;
            }
        }
        return labMappingResultsFormFields;
    }
}
