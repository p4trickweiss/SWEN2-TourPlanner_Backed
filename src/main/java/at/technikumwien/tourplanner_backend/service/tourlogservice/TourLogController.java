package at.technikumwien.tourplanner_backend.service.tourlogservice;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/tourlog")
public class TourLogController {
    private final TourLogService tourLogService;

    public TourLogController(TourLogService tourLogService) {
        this.tourLogService = tourLogService;
    }
}
