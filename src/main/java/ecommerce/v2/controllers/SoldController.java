package ecommerce.v2.controllers;

import ecommerce.v2.configurations.components.Response;
import ecommerce.v2.models.dto.SoldDto;
import ecommerce.v2.models.entities.Sold;
import ecommerce.v2.services.SoldService;
import ecommerce.v2.valids.groups.GroupSoldCreate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SoldController {
    private SoldService soldService;
    @Autowired
    public void setSoldService(SoldService soldService) {
        this.soldService = soldService;
    }
    private ModelMapper modelMapper;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    private Response<Sold, SoldDto> response;
    @Autowired
    public void setResponse(Response<Sold, SoldDto> response) {
        this.response = response;
    }

    @RequestMapping(value = "/sold", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody SoldDto soldDto) {
        return this.response.create(
                (entity) -> this.soldService.create(entity),
                this.modelMapper,
                Sold.class,
                soldDto,
                GroupSoldCreate.class);
    }
    @RequestMapping(value = "/sold", method = RequestMethod.GET)
    public Iterable<Sold> findAll() {
        List<Sold> all = this.soldService.findAll();
        return all;
    }
}
