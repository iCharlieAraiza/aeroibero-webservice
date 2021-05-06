package mx.aeroibero.main.vuelos.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String from;
    private String to;
    private String type;
    private Long distance;
    private int time;
    private Long price;

    public Flight() {
    }

    public Flight(String from, String to, String type, Long distance, int time, Long price) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.distance = distance;
        this.time = time;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
