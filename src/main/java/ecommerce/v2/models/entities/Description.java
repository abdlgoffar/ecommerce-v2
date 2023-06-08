package ecommerce.v2.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity @Table(name = "description")
public class Description {
    @Getter @Setter
    @Id @Column(nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @ManyToMany
    @JoinTable(
            name = "description_size",
            joinColumns = @JoinColumn(name = "description_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id"))
    private Set<Size> sizes;

    @Getter @Setter
    @ManyToMany
    @JoinTable(
            name = "description_color",
            joinColumns = @JoinColumn(name = "description_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id"))
    private Set<Color> colors;

}
