package diaceutics.selenium.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
    private String ivdCe;
    private String ruoIuo;
    private String TurnAroundTime;
    private String associatedDiseases;
    private String method;
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
    private List<Biomarker> biomarkers = new ArrayList<>();

    public void addBiomarker(Biomarker biomarker) {
        biomarkers.add(biomarker);
    }

    public String getClassifications() {
        List<String> classifications = new ArrayList<>();
            if (getFdaPmaApprovedKit().equals("true")) {
                classifications.add("FDA PMA Approved Kit");
            }
            if (getFda510KApprovedKit().equals("true")) {
                classifications.add("FDA 510K Approved Kit");
            }
            if (getRuoIuo().equals("true")) {
                classifications.add("RUO/IUO");
            }
            if (getLaboratoryDevelopedTest().equals("true")) {
                classifications.add("Laboratory Developed Test (LDT)");
            }
            if (getIvdCe().equals("true")) {
                classifications.add("IVD-CE");
            }

        return String.join(",", classifications).replaceAll(",", ", ");
    }
}
