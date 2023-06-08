package ecommerce.v2.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "img")
public class Img {
    @Getter
    @Setter
    @Id
    @Column(nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @Column(nullable = false, length = 800)
    private String name;

    @Getter @Setter
    @Column
    private String type;

    @Getter @Setter
    @Column
    private String path;

    public Img() {
    }

    public Img(String id, String name, String type, String path) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.path = path;
    }
}
