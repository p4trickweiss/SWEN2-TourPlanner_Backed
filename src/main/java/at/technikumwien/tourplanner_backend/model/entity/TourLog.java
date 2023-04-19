package at.technikumwien.tourplanner_backend.model.entity;

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
    private Integer id;
    private LocalDateTime time_stamp;
    private String comment;
    private String difficulty;
    private String total_time;
    private Integer rating;
    @ManyToOne
    @JoinColumn(name = "fk_tourId", nullable = false)
    private Tour tour;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(LocalDateTime timeStamp) {
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
