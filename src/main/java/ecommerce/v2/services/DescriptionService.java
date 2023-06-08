package ecommerce.v2.services;

import ecommerce.v2.models.entities.Description;

import java.util.List;

public interface DescriptionService {
    public abstract Description create(Description description);

    public abstract List<Description> findAll();

    public abstract Description findOneById(String id);
}
