package ecommerce.v2.models.repositories;

import ecommerce.v2.models.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, String> {
}
