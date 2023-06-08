package ecommerce.v2.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity @Table(name = "product")
public class Product {
    @Getter @Setter
    @Id @Column(nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @Column(nullable = false, length = 450)
    private String name;

    @Getter @Setter
    @Column(nullable = false)
    private BigDecimal price;

    @Getter @Setter
    @Column(nullable = false)
    private Double stock;

    @Getter @Setter
    @ManyToOne
    private Category category;

    @Getter @Setter
    @ManyToOne
    private Sold sold;

    @Getter @Setter
    @ManyToOne
    private Description description;

    @Getter @Setter
    @ManyToMany
    @JoinTable(
            name = "product_seller",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "seller_id"))
    private Set<Seller> sellers;

    @OneToMany(mappedBy = "product")
    private Set<SaleProduct> saleProducts;

    /**
     * TO STRING
     * EQUALS AND HASH CODE
     */

}
