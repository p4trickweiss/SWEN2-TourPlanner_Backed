package at.technikumwien.tourplanner_backend.model.dto;

public record NewTour(
        String name,
        String tourDescription,
        String tour_from,
        String tour_to,
        String tour_description,
        String transport_type
) {
}
