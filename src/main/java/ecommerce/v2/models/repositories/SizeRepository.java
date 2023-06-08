package ecommerce.v2.models.repositories;

import ecommerce.v2.models.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, String> {
}
