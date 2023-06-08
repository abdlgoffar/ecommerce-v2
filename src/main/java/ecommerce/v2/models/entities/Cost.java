package ecommerce.v2.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity @Table(name = "cost")
public class Cost {
    @Getter @Setter
    @Id
    @Column(nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @Column(nullable = false)
    private BigDecimal product;

    @Getter @Setter
    @Column(nullable = false)
    private BigDecimal delivery = new BigDecimal(5000);

    @Getter @Setter
    @Column(nullable = false)
    private BigDecimal service = new BigDecimal(2000);

    @Getter @Setter
    @Column(nullable = false)
    private BigDecimal handling = new BigDecimal(1000);
}

