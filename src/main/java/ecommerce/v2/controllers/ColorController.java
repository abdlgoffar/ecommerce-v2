package ecommerce.v2.controllers;

import ecommerce.v2.configurations.components.Response;
import ecommerce.v2.models.dto.ColorDto;
import ecommerce.v2.models.entities.Color;
import ecommerce.v2.services.ColorService;
import ecommerce.v2.valids.groups.GroupColorCreate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ColorController {
    private ColorService colorService;
    @Autowired
    public void setColorService(ColorService colorService) {
        this.colorService = colorService;
    }

    private ModelMapper modelMapper;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    private Response<Color, ColorDto> response;
    @Autowired
    public void setResponse(Response<Color, ColorDto> response) {
        this.response = response;
    }
    @RequestMapping(value = "/colors", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody ColorDto colorDto) {
        return this.response.create(
                (entity) -> this.colorService.create(entity),
                this.modelMapper,
                Color.class,
                colorDto,
                GroupColorCreate.class);
    }
    @RequestMapping(value = "/colors", method = RequestMethod.GET)
    public Iterable<Color> findAll() {
        List<Color> all = this.colorService.findAll();
        return all;
    }
}
