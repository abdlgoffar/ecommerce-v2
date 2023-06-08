package ecommerce.v2.services;

import ecommerce.v2.models.entities.Sold;

import java.util.List;

public interface SoldService {
    public abstract Sold create(Sold sold);
    public abstract List<Sold> findAll();
    public abstract Sold findOneById(String id);
}
