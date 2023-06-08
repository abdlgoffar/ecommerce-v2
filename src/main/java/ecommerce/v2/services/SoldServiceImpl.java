package ecommerce.v2.services;

import ecommerce.v2.configurations.components.IDGenerator;
import ecommerce.v2.models.entities.Sold;
import ecommerce.v2.models.repositories.SoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldServiceImpl implements SoldService{
    private SoldRepository soldRepository;
    @Autowired
    public void setSoldRepository(SoldRepository soldRepository) {
        this.soldRepository = soldRepository;
    }
    private IDGenerator idGenerator;
    @Autowired
    public void setIdGenerator(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public Sold create(Sold sold) {
        sold.setId(this.idGenerator.generate());
        Sold save = this.soldRepository.save(sold);
        return save;
    }

    @Override
    public List<Sold> findAll() {
        List<Sold> all = this.soldRepository.findAll();
        return all;
    }

    @Override
    public Sold findOneById(String id) {
        return null;
    }
}
