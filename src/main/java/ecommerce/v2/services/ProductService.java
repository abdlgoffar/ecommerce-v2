package ecommerce.v2.services;

import ecommerce.v2.models.entities.Product;

import java.util.List;

public interface ProductService {
    public abstract Product create(Product product);
    public abstract List<Product> findAll();
    public abstract Product findOneById(String id);
}
