package ecommerce.v2.services;

import java.util.List;
import java.util.Optional;

import ecommerce.v2.configurations.components.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.v2.models.entities.Color;
import ecommerce.v2.models.repositories.ColorRepository;

@Service
public class ColorServiceImpl implements ColorService {
    private ColorRepository colorRepository;
    @Autowired
    public void setColorRepository(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }
    private IDGenerator idGenerator;
    @Autowired
    public void setIdGenerator(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public Color create(Color color) {
        color.setId(this.idGenerator.generate());
        Color save = this.colorRepository.save(color);
        return save;
    }
    @Override
    public List<Color> findAll() {
        List<Color> all = this.colorRepository.findAll();
        return all;
    }
    @Override
    public Color findOneById(String id) {
        Optional<Color> byId = this.colorRepository.findById(id);
        if (byId.isPresent()) {
            Color color = byId.get();
            return color;
        } else {
            return null;
        }
    }
}
