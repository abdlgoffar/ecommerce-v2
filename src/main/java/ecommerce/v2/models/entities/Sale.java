package ecommerce.v2.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;

@Entity @Table(name = "sale")
public class Sale {
    @Getter @Setter
    @Id @Column(nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @Column(nullable = false, length = 450)
    private String name;

    @Getter @Setter
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "sale")
    Set<SaleProduct> saleProducts;
}
