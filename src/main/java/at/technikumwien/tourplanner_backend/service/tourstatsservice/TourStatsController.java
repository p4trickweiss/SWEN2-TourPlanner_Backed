package at.technikumwien.tourplanner_backend.service.tourstatsservice;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/stats")
public class TourStatsController {
    private final TourStatsService tourStatsService;

    public TourStatsController(TourStatsService statsService) {
        this.tourStatsService = statsService;
    }
}
