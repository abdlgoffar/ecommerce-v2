package ecommerce.v2.services;

import java.util.List;

import ecommerce.v2.models.entities.Color;

public interface ColorService {
    public abstract Color create(Color color);

    public abstract List<Color> findAll();

    public abstract Color findOneById(String id);
}
