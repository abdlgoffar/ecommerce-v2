package ecommerce.v2.services;

import ecommerce.v2.configurations.components.IDGenerator;
import ecommerce.v2.models.entities.Product;
import ecommerce.v2.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    private IDGenerator idGenerator;
    @Autowired
    public void setIdGenerator(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
    @Override
    public Product create(Product product) {
        product.setId(this.idGenerator.generate());
        Product save = this.productRepository.save(product);
        return save;
    }
    @Override
    public List<Product> findAll() {
        List<Product> all = this.productRepository.findAll();
        return all;
    }
    @Override
    public Product findOneById(String id) {
        Optional<Product> byId = this.productRepository.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();
            return product;
        } else {
            return null;
        }
    }
}
