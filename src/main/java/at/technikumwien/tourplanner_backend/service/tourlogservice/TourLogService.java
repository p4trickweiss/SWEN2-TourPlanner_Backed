package at.technikumwien.tourplanner_backend.service.tourlogservice;

import at.technikumwien.tourplanner_backend.model.dto.NewTourLog;
import at.technikumwien.tourplanner_backend.model.entity.Tour;
import at.technikumwien.tourplanner_backend.model.entity.TourLog;
import at.technikumwien.tourplanner_backend.repository.TourLogRepository;
import at.technikumwien.tourplanner_backend.repository.TourRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TourLogService {
    private final TourLogRepository tourLogRepository;
    private final TourRepository tourRepository;

    public TourLogService(TourLogRepository tourLogRepository, TourRepository tourRepository) {
        this.tourLogRepository = tourLogRepository;
        this.tourRepository = tourRepository;
    }

    public void addTourLog(NewTourLog newTourLog) {
        TourLog tourLog = this.mapNewTourLogToTourLog(newTourLog);
        this.tourLogRepository.save(tourLog);
    }

    public void updateTourLog(Long logId, NewTourLog newTourLog) {
        TourLog tourLog = mapNewTourLogToTourLog(newTourLog);
        tourLog.setId(logId);
        this.tourLogRepository.save(tourLog);
    }

    public void deleteLog(Long logId) {
        this.tourLogRepository.deleteById(logId);
    }

    private TourLog mapNewTourLogToTourLog(NewTourLog newTourLog) {
        LocalDateTime timeStamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formatDateTime = timeStamp.format(formatter);

        Tour tour = tourRepository.getReferenceById(newTourLog.fk_tourId());
        TourLog tourLog = new TourLog();
        tourLog.setTour(tour);
        tourLog.setComment(newTourLog.comment());
        tourLog.setDifficulty(newTourLog.difficulty());
        tourLog.setRating(newTourLog.rating());
        tourLog.setTime_stamp(formatDateTime);
        tourLog.setTotal_time(newTourLog.totalTime());

        return tourLog;
    }
}
