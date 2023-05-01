package at.technikumwien.tourplanner_backend.config;

public enum MapQuestConfig {
    INSTANCE;

    private final String getBaseUrl = "http://www.mapquestapi.com/directions/v2/route";
    private final String getImageBaseUrl = "https://www.mapquestapi.com/staticmap/v5/map";
    private final String apiKey = "Wh3vnlIIdnd0kKuAEuU4MVYHqJFAUmin";

    public String getGetBaseUrl() {
        return getBaseUrl;
    }

    public String getGetImageBaseUrl() {
        return getImageBaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}
