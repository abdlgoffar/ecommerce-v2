package ecommerce.v2.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity @Table(name = "seller")
public class Seller {
    @Getter @Setter
    @Id @Column(nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @Column(nullable = false, length = 500)
    private String name;

    @Getter @Setter
    @Column(nullable = false, unique = true, length = 300)
    private String email;
    @ManyToMany(mappedBy = "sellers")
    private Set<Product> products;

    @Getter @Setter
    @ManyToOne
    private Category category;

    /**
     * TO STRING
     * EQUALS AND HASH CODE
     */
}
