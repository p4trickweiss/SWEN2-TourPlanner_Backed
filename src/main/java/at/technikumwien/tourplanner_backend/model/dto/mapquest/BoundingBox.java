package at.technikumwien.tourplanner_backend.model.dto.mapquest;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BoundingBox(
        @JsonProperty("ul")
        Ul ul,
        @JsonProperty("lr")
        Rl lr
) {
}
