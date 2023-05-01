package at.technikumwien.tourplanner_backend.service.tourservice;

import at.technikumwien.tourplanner_backend.config.MapQuestConfig;
import at.technikumwien.tourplanner_backend.model.dto.mapquest.MapQuestJson;
import at.technikumwien.tourplanner_backend.model.dto.mapquest.MapQuestResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class MapQuestRequest {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public MapQuestRequest() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public MapQuestResponse getRouteDetails(String from, String to, String transportType) {
        MapQuestJson mapQuestJson = parseMapQuestResult(getMapQuest(from, to, transportType));
        return createMapQuestResponseObject(mapQuestJson);
    }

    private String getMapQuest(String from, String to, String transportType) {
        String responseBody = null;
        try {
            URI uri = new URI("https://www.mapquestapi.com/directions/v2/route?key=" + MapQuestConfig.INSTANCE.getApiKey()
                    + "&from=" + from.replaceAll("\s", "")
                    + "&to=" + to.replaceAll("\s", "")
                    + "&routeType=" + transportType);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            responseBody = response.body();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return responseBody;
    }

    private MapQuestJson parseMapQuestResult(String mapQuestResult) {
        MapQuestJson res = null;
        try {
            res = objectMapper.readValue(mapQuestResult, MapQuestJson.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    private MapQuestResponse createMapQuestResponseObject(MapQuestJson mapQuestJson) {
        return new MapQuestResponse(
                mapQuestJson.route().distance(),
                mapQuestJson.route().time(),
                createImageUrl(mapQuestJson)
        );
    }

    private String createImageUrl(MapQuestJson mapQuestJson) {
        return "https://www.mapquestapi.com/staticmap/v5/map?key="
                + MapQuestConfig.INSTANCE.getApiKey()
                + "&size=640,480&defaultMarker=none&zoom=11&session=" + mapQuestJson.route().sessionId()
                + "&boundingBox=" + mapQuestJson.route().boundingBox().ul().lat().toString() + "," + mapQuestJson.route().boundingBox().ul().lng().toString() + ","
                + mapQuestJson.route().boundingBox().lr().lat().toString() + "," + mapQuestJson.route().boundingBox().lr().lng().toString();
    }
}
