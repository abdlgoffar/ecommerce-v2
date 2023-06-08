package ecommerce.v2.services;

import ecommerce.v2.configurations.components.IDGenerator;
import ecommerce.v2.models.entities.Category;
import ecommerce.v2.models.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;
    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    private IDGenerator idGenerator;
    @Autowired
    public void setIdGenerator(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }


    @Override
    public Category create(Category category) {
        category.setId(this.idGenerator.generate());
        Category save = this.categoryRepository.save(category);
        return save;
    }

    @Override
    public List<Category> findAll() {
        List<Category> all = this.categoryRepository.findAll();
        return all;
    }

    @Override
    public Category findOneById(String id) {
        Optional<Category> byId = this.categoryRepository.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            return category;
        } else {
            return null;
        }
    }
}
