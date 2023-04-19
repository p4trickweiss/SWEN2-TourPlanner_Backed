package at.technikumwien.tourplanner_backend.model.dto;

public record NewTourLog(
        String comment,
        String difficulty,
        String totalTime,
        Integer rating,
        Integer fk_tourId
) {
}
