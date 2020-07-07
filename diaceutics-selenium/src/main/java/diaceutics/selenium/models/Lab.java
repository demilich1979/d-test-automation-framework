package diaceutics.selenium.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Lab extends BaseModel {
    private String name;
    private String country;
    private String url;
    private String labType;
    private List<Location> locations = new ArrayList<>();
    private List<Assay> assays = new ArrayList<>();

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void addAssay(Assay assay) {
        assays.add(assay);
    }

    public Assay getAssayByName(String assayName) {
        return assays.stream()
                .filter(assay -> assay.getAssayName().equals(assayName))
                .findFirst()
                .orElse(null);
    }
}
