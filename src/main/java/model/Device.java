package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "duration_30_min")
    private Double duration30Min;

    @Getter
    @Setter
    @Column(name = "duration_1_hour")
    private Double duration1Hour;

    @Getter
    @Setter
    @Column(name = "duration_3_hours")
    private Double duration3Hours;

    @Getter
    @Setter
    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    @Getter
    @Setter
    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Hookah> hookahs;

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", duration30Min=" + duration30Min +
                ", duration1Hour=" + duration1Hour +
                ", duration3Hours=" + duration3Hours +
                // Avoid directly printing products and hookahs here if lazy-loaded
                '}';
    }
}
