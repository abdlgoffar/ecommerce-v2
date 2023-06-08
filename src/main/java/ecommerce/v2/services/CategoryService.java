package ecommerce.v2.services;

import ecommerce.v2.models.entities.Category;

import java.util.List;

public interface CategoryService {
    public abstract Category create(Category category);
    public abstract List<Category> findAll();
    public abstract Category findOneById(String  id);
}
