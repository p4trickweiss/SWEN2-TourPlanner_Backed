package at.technikumwien.tourplanner_backend.service.tourlogservice;

import at.technikumwien.tourplanner_backend.model.dto.NewTourLog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TourLogController.class)

class TourLogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TourLogService tourLogService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void postLog() throws Exception{
        NewTourLog newTourLog = new NewTourLog(
                "Comment",
                "difficulty",
                "05:00",
                5,
                0L
        );

        this.mockMvc.perform(post("/api/tour-log").contentType("application/json").content(objectMapper.writeValueAsString(newTourLog)))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void postLog_noContent() throws Exception{
        this.mockMvc.perform(post("/api/tour-log").contentType("application/json"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void updateLog() throws Exception{
        NewTourLog newTourLog = new NewTourLog(
                "Comment",
                "difficulty",
                "05:00",
                5,
                0L
        );

        this.mockMvc.perform(put("/api/tour-log/0").contentType("application/json").content(objectMapper.writeValueAsString(newTourLog)))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void updateLog_noContent() throws Exception{
        this.mockMvc.perform(put("/api/tour-log/0").contentType("application/json"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void updateLog_noId() throws Exception{
        NewTourLog newTourLog = new NewTourLog(
                "Comment",
                "difficulty",
                "05:00",
                5,
                0L
        );

        this.mockMvc.perform(put("/api/tour-log").contentType("application/json").content(objectMapper.writeValueAsString(newTourLog)))
                .andDo(print()).andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void deleteLog() throws Exception{
        this.mockMvc.perform(delete("/api/tour-log/0").contentType("application/json"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteLog_noId() throws Exception{
        this.mockMvc.perform(delete("/api/tour-log").contentType("application/json"))
                .andDo(print()).andExpect(status().isMethodNotAllowed());
    }
}