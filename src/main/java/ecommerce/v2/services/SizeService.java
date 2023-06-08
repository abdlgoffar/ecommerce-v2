package ecommerce.v2.services;

import ecommerce.v2.models.entities.Size;

import java.util.List;

public interface SizeService {
    public abstract Size create(Size size);
    public abstract List<Size> findAll();
    public abstract Size findOneById(String id);
}
