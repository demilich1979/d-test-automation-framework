package diaceutics.selenium.enums.propertykeys;

public enum PropertyKeys {
    API_KEY("apiKey"),
    SERVER_ID("serverId");

    private final String key;

    PropertyKeys(String key) {
        this.key = key;
    }

    public String toString() {
        return key;
    }
}
