package ecommerce.v2.services;

import ecommerce.v2.models.entities.Cart;

import java.util.List;

public interface CartService {
    public abstract Cart create(Cart cart);
    public abstract List<Cart> findAll();
    public abstract Cart findOneById(String id);
}
