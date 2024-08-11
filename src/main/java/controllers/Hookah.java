package controllers;

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
    @JoinColumn(name = "playstation_id", nullable = false)
    private Playstation playStation;

    // Constructors, getters, and setters

    public Hookah(String flavor, Double price, Playstation playStation) {
        this.flavor = flavor;
        this.price = price;
        this.playStation = playStation;
    }
}
