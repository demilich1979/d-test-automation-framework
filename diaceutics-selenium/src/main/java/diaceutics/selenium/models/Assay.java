package diaceutics.selenium.models;

import lombok.Data;

@Data
public class Assay extends BaseModel {

    private String assayName;
    private String assayDescription;
    private String ontologies;
    private String specimensTested;
    private String detectsGermLineSomaticAlterations;
    private String fda510KApprovedKit;
    private String laboratoryDevelopedTest;
    private String fdaPmaApprovedKit;
    private String TurnAroundTime;
    private String associatedDiseases;
    private String methodDescription;
    private String commercialAssays;
    private String resultFormat;
    private String sendOutOrInHouse;
    private String sendOutLab;
    private String panelNameRadio;
    private String accuracy;
    private String precision;
    private String sensitivity;
    private String batchOrIndividual;
    private String variantsIncluded;

}
