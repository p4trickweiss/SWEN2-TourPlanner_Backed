package at.technikumwien.tourplanner_backend.service.tourservice;

import at.technikumwien.tourplanner_backend.model.dto.NewTour;
import at.technikumwien.tourplanner_backend.model.dto.mapquest.MapQuestResponse;
import at.technikumwien.tourplanner_backend.model.entity.Tour;
import at.technikumwien.tourplanner_backend.repository.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {
    private final TourRepository tourRepository;
    private final MapQuestRequest mapQuestRequest;

    public TourService(TourRepository tourRepository, MapQuestRequest mapQuestRequest) {
        this.tourRepository = tourRepository;
        this.mapQuestRequest = mapQuestRequest;
    }
    public List<Tour> getTours() {
        return this.tourRepository.findAll();
    }

    public Optional<Tour> getTourById(Long tourId) {
        return this.tourRepository.findById(tourId);
    }

    public void addTour(NewTour newTour) {
        MapQuestResponse mapQuestResponse = mapQuestRequest.getRouteDetails(newTour.tour_from(), newTour.tour_to(), newTour.transport_type());
        Tour tour = createTourFromNewTourAndMapQuestResponse(newTour, mapQuestResponse);

        tourRepository.save(tour);
    }

    public void updateTour(Long tourId, NewTour newTour) {
        MapQuestResponse mapQuestResponse = mapQuestRequest.getRouteDetails(newTour.tour_from(), newTour.tour_to(), newTour.transport_type());
        Tour tour = createTourFromNewTourAndMapQuestResponse(newTour, mapQuestResponse);
        tour.setId(tourId);

        tourRepository.save(tour);
    }

    public void deleteTour(Long tourId) {
        tourRepository.deleteById(tourId);
    }

    private Tour createTourFromNewTourAndMapQuestResponse(NewTour newTour, MapQuestResponse mapQuestResponse) {
        Tour tour = new Tour();
        tour.setName(newTour.name());
        tour.setTour_description(newTour.tour_description());
        tour.setTour_from(newTour.tour_from());
        tour.setTour_to(newTour.tour_to());
        tour.setTransport_type(newTour.transport_type());
        tour.setTour_distance(mapQuestResponse.distance().toString());
        tour.setEstimated_time(mapQuestResponse.time());
        tour.setRoute_information(mapQuestResponse.imageURL());
        return tour;
    }
}
