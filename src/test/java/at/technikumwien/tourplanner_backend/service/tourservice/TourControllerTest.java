package at.technikumwien.tourplanner_backend.service.tourservice;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import at.technikumwien.tourplanner_backend.model.dto.NewTour;
import at.technikumwien.tourplanner_backend.model.entity.Tour;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

@WebMvcTest(TourController.class)

class TourControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TourService tourService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getTours() throws Exception {
        Tour tour = new Tour();
        tour.setName("TestTour");

        when(tourService.getTours()).thenReturn(List.of(tour));
        this.mockMvc.perform(get("/api/tour")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("TestTour")));
    }

    @Test
    public void getTourById() throws Exception {
        Tour tour = new Tour();
        tour.setName("TestTour");
        tour.setId(0L);

        when(tourService.getTourById(any())).thenReturn(Optional.of(tour));
        this.mockMvc.perform(get("/api/tour/0")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":0")));
    }

    @Test
    public void postTour() throws Exception {
        NewTour newTour = new NewTour(
                "TestTour",
                "Desc",
                "From",
                "To",
                "type"
        );

        this.mockMvc.perform(post("/api/tour").contentType("application/json").content(objectMapper.writeValueAsString(newTour)))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void postTour_noContent() throws Exception {
        this.mockMvc.perform(post("/api/tour").contentType("application/json"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void updateTour() throws Exception {
        NewTour newTour = new NewTour(
                "TestTour",
                "Desc",
                "From",
                "To",
                "type"
        );

        this.mockMvc.perform(put("/api/tour/0").contentType("application/json").content(objectMapper.writeValueAsString(newTour)))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void updateTour_noId() throws Exception {
        NewTour newTour = new NewTour(
                "TestTour",
                "Desc",
                "From",
                "To",
                "type"
        );

        this.mockMvc.perform(put("/api/tour").contentType("application/json").content(objectMapper.writeValueAsString(newTour)))
                .andDo(print()).andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void updateTour_noContent() throws Exception {
              this.mockMvc.perform(put("/api/tour/0").contentType("application/json"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void deleteTour() throws Exception {
        this.mockMvc.perform(delete("/api/tour/0"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteTour_noId() throws Exception {
        this.mockMvc.perform(delete("/api/tour"))
                .andDo(print()).andExpect(status().isMethodNotAllowed());
    }
}