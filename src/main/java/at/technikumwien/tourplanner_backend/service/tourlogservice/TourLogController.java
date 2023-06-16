package at.technikumwien.tourplanner_backend.service.tourlogservice;

import at.technikumwien.tourplanner_backend.model.dto.NewTourLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tour-log")
public class TourLogController {
    Logger logger = LoggerFactory.getLogger(TourLogController.class);
    private final TourLogService tourLogService;

    public TourLogController(TourLogService tourLogService) {
        this.tourLogService = tourLogService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void addLog(@RequestBody NewTourLog newTourLog) {
        logger.info("addLog called");
        this.tourLogService.addTourLog(newTourLog);
    }

    @PutMapping("/{logId}")
    public void updateLog(@PathVariable("logId") Long logId, @RequestBody NewTourLog newTourLog) {
        logger.info("updateLog called");
        this.tourLogService.updateTourLog(logId, newTourLog);
    }

    @DeleteMapping("/{logId}")
    public void deleteLog(@PathVariable("logId") Long logId) {
        logger.info("deleteLog called");
        this.tourLogService.deleteLog(logId);
    }
}
