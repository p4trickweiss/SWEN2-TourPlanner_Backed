package at.technikumwien.tourplanner_backend.model.dto;

public record NewTourLog(
        String comment,
        String difficulty,
        String totalTime,
        Integer rating,
        Long fk_tourId
) {
}
