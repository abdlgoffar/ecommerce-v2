package ecommerce.v2.controllers;

import ecommerce.v2.configurations.components.Response;
import ecommerce.v2.models.dto.SizeDto;
import ecommerce.v2.models.entities.Size;
import ecommerce.v2.services.SizeService;
import ecommerce.v2.valids.groups.GroupSizeCreate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SizeController {
    private SizeService sizeService;
    @Autowired
    public void setSizeService(SizeService sizeService) {
        this.sizeService = sizeService;
    }
    private ModelMapper modelMapper;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    private Response<Size, SizeDto> response;
    @Autowired
    public void setResponse(Response<Size, SizeDto> response) {
        this.response = response;
    }
    @RequestMapping(value = "/sizes", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody SizeDto sizeDto) {
        return this.response.create(
                (entity) -> this.sizeService.create(entity),
                this.modelMapper,
                Size.class,
                sizeDto,
                GroupSizeCreate.class);
    }
    @RequestMapping(value = "/sizes", method = RequestMethod.GET)
    public Iterable<Size> findAll() {
        List<Size> all = this.sizeService.findAll();
        return all;
    }
}
