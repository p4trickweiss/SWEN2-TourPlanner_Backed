package at.technikumwien.tourplanner_backend.model.dto.mapquest;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Ul(
        @JsonProperty("lat")
        Double lat,
        @JsonProperty("lng")
        Double lng
) {
}
