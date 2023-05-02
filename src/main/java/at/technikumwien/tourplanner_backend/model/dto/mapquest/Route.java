package at.technikumwien.tourplanner_backend.model.dto.mapquest;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Route(
        @JsonProperty("sessionId")
        String sessionId,
        @JsonProperty("distance")
        Integer distance,
        @JsonProperty("formattedTime")
        String time,
        @JsonProperty("boundingBox")
        BoundingBox boundingBox
) {
}
