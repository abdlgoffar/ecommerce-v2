package ecommerce.v2.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity @Table(name = "sold")
public class Sold {
    @Getter @Setter
    @Id
    @Column(nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @Column(nullable = false)
    private Double amount = 0.0;
}
