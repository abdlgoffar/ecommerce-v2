package ecommerce.v2.models.repositories;

import ecommerce.v2.models.entities.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImgRepository extends JpaRepository<Img, String> {

    Optional<Img> findByName(String name);
}
