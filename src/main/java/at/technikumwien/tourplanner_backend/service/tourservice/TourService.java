package at.technikumwien.tourplanner_backend.service.tourservice;

import at.technikumwien.tourplanner_backend.model.dto.NewTour;
import at.technikumwien.tourplanner_backend.model.entity.Tour;
import at.technikumwien.tourplanner_backend.repository.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {
    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> getTours() {
        return this.tourRepository.findAll();
    }

    public Optional<Tour> getTourById(Integer tourId) {
        return this.tourRepository.findById(tourId);
    }

    public void addTour(NewTour newTour) {
        Tour tour = new Tour();
        tour.setName(newTour.name());
        tour.setTour_description(newTour.tour_description());
        tour.setTour_from(newTour.tour_from());
        tour.setTour_to(newTour.tour_to());
        tour.setTransport_type(newTour.transport_type());

        tourRepository.save(tour);
    }

    public void updateTour(Integer tourId, NewTour newTour) {
        Tour tour = new Tour();
        tour.setId(tourId);
        tour.setName(newTour.name());
        tour.setTour_description(newTour.tourDescription());
        tour.setTour_from(newTour.tour_from());
        tour.setTour_to(newTour.tour_to());
        tour.setTransport_type(newTour.transport_type());

        tourRepository.save(tour);
    }

    public void deleteTour(Integer tourId) {
        tourRepository.deleteById(tourId);
    }
}
