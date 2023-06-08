package ecommerce.v2.models.repositories;

import ecommerce.v2.models.entities.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, String> {
}
