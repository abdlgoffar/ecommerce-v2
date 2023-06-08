package ecommerce.v2.services;

import ecommerce.v2.configurations.components.IDGenerator;
import ecommerce.v2.models.entities.Seller;
import ecommerce.v2.models.repositories.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {
    private SellerRepository sellerRepository;
    @Autowired
    public void setSellerRepository(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
    private IDGenerator idGenerator;
    @Autowired
    public void setIdGenerator(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
    @Override
    public Seller create(Seller seller) {
        seller.setId(this.idGenerator.generate());
        Seller save = this.sellerRepository.save(seller);
        return save;
    }
    @Override
    public List<Seller> findAll() {
        List<Seller> all = this.sellerRepository.findAll();
        return all;
    }
    @Override
    public Seller findOneById(String id) {
        Optional<Seller> byId = this.sellerRepository.findById(id);
        if (byId.isPresent()) {
            Seller seller = byId.get();
            return seller;
        } else {
            return null;
        }
    }
}
