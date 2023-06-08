package ecommerce.v2.services;

import ecommerce.v2.configurations.components.IDGenerator;
import ecommerce.v2.models.entities.Description;
import ecommerce.v2.models.repositories.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescriptionServiceImpl implements DescriptionService{
    private DescriptionRepository descriptionRepository;
    @Autowired
    public void setDescriptionRepository(DescriptionRepository descriptionRepository) {
        this.descriptionRepository = descriptionRepository;
    }
    private IDGenerator idGenerator;
    @Autowired
    public void setIdGenerator(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public Description create(Description description) {
        description.setId(this.idGenerator.generate());
        Description save = this.descriptionRepository.save(description);
        return save;
    }

    @Override
    public List<Description> findAll() {
        List<Description> all = this.descriptionRepository.findAll();
        return all;
    }

    @Override
    public Description findOneById(String id) {
        Optional<Description> byId = this.descriptionRepository.findById(id);
        if (byId.isPresent()) {
            Description description = byId.get();
            return description;
        } else {
            return null;
        }
    }
}
