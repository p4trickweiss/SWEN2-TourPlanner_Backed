package at.technikumwien.tourplanner_backend.repository;

import at.technikumwien.tourplanner_backend.model.entity.TourLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourLogRepository
    extends JpaRepository<TourLog, Long> {
}
