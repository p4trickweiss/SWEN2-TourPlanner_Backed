package at.technikumwien.tourplanner_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tour {
    @Id
    @SequenceGenerator(
            name = "tour_id_sequence",
            sequenceName = "tour_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tour_id_sequence"
    )
    private Long id;
    private String name;
    private String tour_description;
    private String tour_from;
    private String tour_to;
    private String transport_type;
    private String tour_distance;
    private String estimated_time;
    private String route_information;
    @OneToMany(mappedBy = "tour", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("tour") // ignore tour property in TourLog
    private List<TourLog> tourLogs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTour_description() {
        return tour_description;
    }

    public void setTour_description(String tour_description) {
        this.tour_description = tour_description;
    }

    public String getTour_from() {
        return tour_from;
    }

    public void setTour_from(String tour_from) {
        this.tour_from = tour_from;
    }

    public String getTour_to() {
        return tour_to;
    }

    public void setTour_to(String tour_to) {
        this.tour_to = tour_to;
    }

    public String getTransport_type() {
        return transport_type;
    }

    public void setTransport_type(String transport_type) {
        this.transport_type = transport_type;
    }

    public String getTour_distance() {
        return tour_distance;
    }

    public void setTour_distance(String tour_distance) {
        this.tour_distance = tour_distance;
    }

    public String getEstimated_time() {
        return estimated_time;
    }

    public void setEstimated_time(String estimated_time) {
        this.estimated_time = estimated_time;
    }

    public String getRoute_information() {
        return route_information;
    }

    public void setRoute_information(String route_information) {
        this.route_information = route_information;
    }

    public List<TourLog> getTourLogs() {
        return tourLogs;
    }

    public void setTourLogs(List<TourLog> tourLogs) {
        this.tourLogs = tourLogs;
    }
}
