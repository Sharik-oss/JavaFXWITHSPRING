package controllers;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;


    @Getter
    @Setter
    @Column(name = "price", nullable = false)
    private Double price;


    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "playstation_id", nullable = false)
    private Playstation playStation;

    public Product(String name, Double price, Playstation playStation) {
        this.name = name;
        this.price = price;
        this.playStation = playStation;
    }

}
