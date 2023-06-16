package at.technikumwien.tourplanner_backend.service.tourservice;

import at.technikumwien.tourplanner_backend.model.entity.Tour;
import at.technikumwien.tourplanner_backend.repository.TourRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TourServiceTest {

    @Mock
    private TourRepository tourRepository;

    @Test
    void getTours_empty() {
        when(tourRepository.findAll()).thenReturn(List.of());
        List<Tour> test = tourRepository.findAll();

        Assertions.assertEquals(test.size(), 0);
    }

    @Test
    void getTours() {
        Tour tour1 = new Tour();
        Tour tour2 = new Tour();

        when(tourRepository.findAll()).thenReturn(List.of(tour1, tour2));
        List<Tour> test = tourRepository.findAll();

        Assertions.assertEquals(test.size(), 2);
    }

    @Test
    void getTourById_fail() {
        Tour tour = new Tour();
        tour.setId(1L);

        when(tourRepository.findById(anyLong())).thenReturn(Optional.of(tour));
        Tour test = tourRepository.findById(0L).get();

        Assertions.assertNotEquals(test.getId(), 0);
    }

    @Test
    void getTourById() {
        Tour tour = new Tour();
        tour.setId(1L);

        when(tourRepository.findById(anyLong())).thenReturn(Optional.of(tour));
        Tour test = tourRepository.findById(1L).get();

        Assertions.assertEquals(test.getId(), 1);
    }
}