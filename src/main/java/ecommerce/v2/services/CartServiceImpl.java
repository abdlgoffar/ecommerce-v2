package ecommerce.v2.services;

import ecommerce.v2.configurations.components.IDGenerator;
import ecommerce.v2.models.entities.Cart;
import ecommerce.v2.models.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;
    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    private IDGenerator idGenerator;
    @Autowired
    public void setIdGenerator(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart create(Cart cart) {
        cart.setId(this.idGenerator.generate());
        Cart save = this.cartRepository.save(cart);
        return save;
    }

    @Override
    public List<Cart> findAll() {
        List<Cart> all = this.cartRepository.findAll();
        return all;
    }

    @Override
    public Cart findOneById(String id) {
        Optional<Cart> byId = this.cartRepository.findById(id);
        if (byId.isPresent()) {
            Cart cart = byId.get();
            return cart;
        } else {
            return null;
        }
    }
}
