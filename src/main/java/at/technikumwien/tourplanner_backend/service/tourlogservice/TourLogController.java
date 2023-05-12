package at.technikumwien.tourplanner_backend.service.tourlogservice;

import at.technikumwien.tourplanner_backend.model.dto.NewTourLog;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tour-log")
public class TourLogController {
    private final TourLogService tourLogService;

    public TourLogController(TourLogService tourLogService) {
        this.tourLogService = tourLogService;
    }

    @PostMapping()
    public void addLog(@RequestBody NewTourLog newTourLog) {
        this.tourLogService.addTourLog(newTourLog);
    }

    @PutMapping("/{logId}")
    public void updateLog(@PathVariable("logId") Long logId, @RequestBody NewTourLog newTourLog) {
        this.tourLogService.updateTourLog(logId, newTourLog);
    }

    @DeleteMapping("/{logId}")
    public void deleteLog(@PathVariable("logId") Long logId) {
        this.tourLogService.deleteLog(logId);
    }
}
