package ecommerce.v2.controllers;

import ecommerce.v2.configurations.components.Response;
import ecommerce.v2.models.dto.DescriptionDto;
import ecommerce.v2.models.entities.Description;
import ecommerce.v2.services.DescriptionService;
import ecommerce.v2.valids.groups.GroupDescriptionCreate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DescriptionController {
    private DescriptionService descriptionService;
    @Autowired
    public void setDescriptionService(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }
    private ModelMapper modelMapper;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    private Response<Description, DescriptionDto> response;
    @Autowired
    public void setResponse(Response<Description, DescriptionDto> response) {
        this.response = response;
    }
    @RequestMapping(value = "/descriptions", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody DescriptionDto descriptionDto) {
        return this.response.create(
                (entity) -> this.descriptionService.create(entity),
                this.modelMapper,
                Description.class,
                descriptionDto,
                GroupDescriptionCreate.class);
    }
    @RequestMapping(value = "/descriptions", method = RequestMethod.GET)
    public Iterable<Description> findAll() {
        List<Description> all = this.descriptionService.findAll();
        return all;
    }
}
