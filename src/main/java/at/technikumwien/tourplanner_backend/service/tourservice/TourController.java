package at.technikumwien.tourplanner_backend.service.tourservice;


import at.technikumwien.tourplanner_backend.model.dto.NewTour;
import at.technikumwien.tourplanner_backend.model.entity.Tour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/tour")
public class  TourController {
    Logger logger = LoggerFactory.getLogger(TourController.class);
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public List<Tour> getTours() {
        logger.info("getTours called");
        return this.tourService.getTours();
    }

    @GetMapping("/{tourId}")
    public Tour getTourById(@PathVariable("tourId") Long tourId) {
        logger.info("getToursById called");
        return this.tourService.getTourById(tourId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addTour(@RequestBody NewTour newTour) {
        logger.info("addTour called");
        this.tourService.addTour(newTour);
    }

    @PutMapping("/{tourId}")
    public void updateTour(@PathVariable("tourId") Long tourId, @RequestBody NewTour tour) {
        logger.info("updateTour called");
        this.tourService.updateTour(tourId, tour);
    }

    @DeleteMapping("/{tourId}")
    public void deleteTour(@PathVariable("tourId") Long tourId) {
        logger.info("deleteTour called");
        this.tourService.deleteTour(tourId);
    }

    @DeleteMapping("/delete")
    public void deleteAll() {
        logger.info("deleteAll called");
        this.tourService.deleteAll();
    }
}
