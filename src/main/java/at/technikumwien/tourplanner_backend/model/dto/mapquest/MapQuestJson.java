package at.technikumwien.tourplanner_backend.model.dto.mapquest;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MapQuestJson(
        @JsonProperty("route")
        Route route
) {
}
