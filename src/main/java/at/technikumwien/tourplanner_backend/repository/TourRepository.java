package at.technikumwien.tourplanner_backend.repository;

import at.technikumwien.tourplanner_backend.model.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository
        extends JpaRepository<Tour, Long> {
}