package at.technikumwien.tourplanner_backend.model.dto.mapquest;

public record MapQuestResponse(
        Integer distance,
        String time,
        String imageURL
) {
}
