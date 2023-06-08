package ecommerce.v2.services;

import ecommerce.v2.configurations.components.IDGenerator;
import ecommerce.v2.models.entities.Sale;
import ecommerce.v2.models.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService{
    private SaleRepository saleRepository;
    @Autowired
    public void setSaleRepository(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }
    private IDGenerator idGenerator;
    @Autowired
    public void setIdGenerator(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public Sale create(Sale sale) {
        sale.setId(this.idGenerator.generate());
        Sale save = this.saleRepository.save(sale);
        return sale;
    }

    @Override
    public List<Sale> findAll() {
        List<Sale> all = this.saleRepository.findAll();
        return all;
    }

    @Override
    public Sale findOneById(String id) {
        Optional<Sale> byId = this.saleRepository.findById(id);
        if (byId.isPresent()) {
            Sale sale = byId.get();
            return sale;
        } else {
            return null;
        }
    }
}
