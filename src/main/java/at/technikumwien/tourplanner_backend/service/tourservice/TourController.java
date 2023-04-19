package at.technikumwien.tourplanner_backend.service.tourservice;


import at.technikumwien.tourplanner_backend.model.dto.NewTour;
import at.technikumwien.tourplanner_backend.model.entity.Tour;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/tour")
public class  TourController {
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public List<Tour> getTours() {
        return this.tourService.getTours();
    }

    @GetMapping("/{tourId}")
    public Tour getTourById(@PathVariable("tourId") Integer tourId) {
        return this.tourService.getTourById(tourId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addTour(@RequestBody NewTour newTour) {
        this.tourService.addTour(newTour);
    }

    @PutMapping("/{tourId}")
    public void updateTour(@PathVariable("tourId") Integer tourId, @RequestBody NewTour tour) {
        this.tourService.updateTour(tourId, tour);
    }

    @DeleteMapping("/{tourId}")
    public void deleteTour(@PathVariable("tourId") Integer tourId) {
        this.tourService.deleteTour(tourId);
    }
}
