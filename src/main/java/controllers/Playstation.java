package controllers;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "playstation")
public class Playstation {
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

    @Setter
    @Getter
    @Column(name = "duration_3_hours")
    private Double duration3Hours;

    @Setter
    @Getter
    @Column(name = "vip")
    private Boolean vip;

    @Setter
    @Getter
    @OneToMany(mappedBy = "playStation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    @Getter
    @Setter
    @OneToMany(mappedBy = "playStation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Hookah> hookahs;


    public void PlayStation(String name, Double duration30Min, Double duration1Hour, Double duration3Hours, Boolean vip, List<Product> products, List<Hookah> hookahs) {
        this.name = name;
        this.duration30Min = duration30Min;
        this.duration1Hour = duration1Hour;
        this.duration3Hours = duration3Hours;
        this.vip = vip;
        this.products = products;
        this.hookahs = hookahs;

    }
}
