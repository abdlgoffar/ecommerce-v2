package ecommerce.v2.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity @Table(name = "size")
public class Size {
    @Getter
    @Setter
    @Id
    @Column(nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "sizes")
    private Set<Description> descriptions;
}
