package ecommerce.v2.models.repositories;

import ecommerce.v2.models.entities.Sold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldRepository extends JpaRepository<Sold, String> {
}
