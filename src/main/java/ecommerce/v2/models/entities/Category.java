package ecommerce.v2.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "category")
public class Category {
    @Getter @Setter
    @Id @Column(nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @Column(nullable = false, length = 450)
    private String name;

    @Getter @Setter
    @ManyToOne
    private Img img;
    /**
     * TO STRING
     * EQUALS AND HASH CODE
     */
}
