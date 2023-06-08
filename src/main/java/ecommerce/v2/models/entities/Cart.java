package ecommerce.v2.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity @Table(name = "cart")
public class Cart {
    @Getter @Setter
    @Id @Column(nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @Column(nullable = false, length = 450)
    private String name;

    @Getter @Setter
    @ManyToOne
    private User user;

    @Getter @Setter
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="cart_id", referencedColumnName = "id")
    private Set<Product> products;

    /**
     * TO STRING
     * EQUALS AND HASH CODE
     */

}
