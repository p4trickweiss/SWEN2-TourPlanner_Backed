package at.technikumwien.tourplanner_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TourLog {
    @Id
    @SequenceGenerator(
            name = "tour_log_id_sequence",
            sequenceName = "tour_log_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tour_log_id_sequence"
    )
    private Long id;
    private String time_stamp;
    private String comment;
    private String difficulty;
    private String total_time;
    private Integer rating;
    @ManyToOne
    @JoinColumn(name = "fk_tourId", nullable = false)
    private Tour tour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String timeStamp) {
        this.time_stamp = timeStamp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String totalTime) {
        this.total_time = totalTime;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
