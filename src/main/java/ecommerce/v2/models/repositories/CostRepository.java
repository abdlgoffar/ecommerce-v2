package ecommerce.v2.models.repositories;

import ecommerce.v2.models.entities.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends JpaRepository<Cost, String> {
}
