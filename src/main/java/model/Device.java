package model;

import jakarta.persistence.*;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double duration30Min;
    private Double duration1Hour;
    private Double duration3Hours;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDuration30Min() {
        return duration30Min;
    }

    public void setDuration30Min(Double duration30Min) {
        this.duration30Min = duration30Min;
    }

    public Double getDuration1Hour() {
        return duration1Hour;
    }

    public void setDuration1Hour(Double duration1Hour) {
        this.duration1Hour = duration1Hour;
    }

    public Double getDuration3Hours() {
        return duration3Hours;
    }

    public void setDuration3Hours(Double duration3Hours) {
        this.duration3Hours = duration3Hours;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration30Min=" + duration30Min +
                ", duration1Hour=" + duration1Hour +
                ", duration3Hours=" + duration3Hours +
                '}';
    }
}
