package diaceutics.selenium.models;

import lombok.Data;

@Data
public class MarketplaceSearchTemplate extends BaseModel {
    private String location;
    private String type;
    private String keywords;
    private String categories;
    private String laboratory;
    private String pharmaceutical;
    private String diagnostic;
}
