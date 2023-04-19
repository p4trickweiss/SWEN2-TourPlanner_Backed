package at.technikumwien.tourplanner_backend.service.logservice;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/log")
public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }
}
