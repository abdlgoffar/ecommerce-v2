package ecommerce.v2.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity @Table(name = "sale_product")
public class SaleProduct {
    @Getter @Setter
    @Id @Column(nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Getter @Setter
    private Long quantity = 1L;

    @Getter @Setter
    @ManyToOne
    private Cost cost;

    @Getter @Setter
    private BigDecimal total;
}
