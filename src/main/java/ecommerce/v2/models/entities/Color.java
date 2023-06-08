package ecommerce.v2.models.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity @Table(name = "color")
public class Color {
    @Getter @Setter
    @Id @Column(nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToMany(mappedBy = "colors")
    private Set<Description> descriptions;
}
