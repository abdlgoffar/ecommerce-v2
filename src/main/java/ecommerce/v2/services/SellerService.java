package ecommerce.v2.services;

import ecommerce.v2.models.entities.Seller;

import java.util.List;

public interface SellerService {
    public abstract Seller create(Seller seller);
    public abstract List<Seller> findAll();
    public abstract Seller findOneById(String id);
}
