package at.technikumwien.tourplanner_backend.model.dto;

public record NewTour(
        String name,
        String tour_description,
        String tour_from,
        String tour_to,
        String transport_type
) {
}
