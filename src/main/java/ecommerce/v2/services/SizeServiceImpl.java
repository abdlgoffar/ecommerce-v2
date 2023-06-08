package ecommerce.v2.services;

import ecommerce.v2.configurations.components.IDGenerator;
import ecommerce.v2.models.entities.Size;
import ecommerce.v2.models.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImpl implements SizeService{
    private SizeRepository sizeRepository;
    @Autowired
    public void setSizeRepository(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }
    private IDGenerator idGenerator;
    @Autowired
    public void setIdGenerator(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public Size create(Size size) {
        size.setId(this.idGenerator.generate());
        Size save = this.sizeRepository.save(size);
        return save;
    }

    @Override
    public List<Size> findAll() {
        List<Size> all = this.sizeRepository.findAll();
        return all;
    }

    @Override
    public Size findOneById(String id) {
        Optional<Size> byId = this.sizeRepository.findById(id);
        if (byId.isPresent()) {
            Size size = byId.get();
            return size;
        } else {
            return null;
        }
    }
}
