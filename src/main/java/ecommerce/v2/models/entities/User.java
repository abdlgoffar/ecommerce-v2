package ecommerce.v2.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
public class User {
    @Getter @Setter
    @Id @Column(nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @Column(nullable = false)
    private String username;

    @Getter @Setter
    @Column(nullable = false)
    private String email;

    @Getter @Setter
    @Column(nullable = false)
    private String password;

}
