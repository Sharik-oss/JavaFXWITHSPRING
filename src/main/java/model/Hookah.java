package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

public class Hookah {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Getter
    @Setter
    @Column(name = "flavor", nullable = false)
    private String flavor;


    @Getter
    @Setter
    @Column(name = "price", nullable = false)
    private Double price;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    // Constructors, getters, and setters

    public Hookah(String flavor, Double price, Device device) {
        this.flavor = flavor;
        this.price = price;
        this.device = device;
    }
}
