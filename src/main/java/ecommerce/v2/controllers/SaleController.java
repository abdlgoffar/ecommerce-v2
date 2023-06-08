package ecommerce.v2.controllers;

import ecommerce.v2.configurations.components.Response;
import ecommerce.v2.models.dto.SaleDto;
import ecommerce.v2.models.entities.Sale;
import ecommerce.v2.services.SaleService;
import ecommerce.v2.valids.groups.GroupSaleCreate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaleController {
    private SaleService saleService;
    @Autowired
    public void setSaleService(SaleService saleService) {
        this.saleService = saleService;
    }
    private ModelMapper modelMapper;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    private Response<Sale, SaleDto> response;
    @Autowired
    public void setResponse(Response<Sale, SaleDto> response) {
        this.response = response;
    }

    @RequestMapping(value = "/sales", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody SaleDto saleDto) {
        return this.response.create(
                (entity) -> this.saleService.create(entity),
                this.modelMapper,
                Sale.class,
                saleDto,
                GroupSaleCreate.class);
    }
    @RequestMapping(value = "/sales", method = RequestMethod.GET)
    public Iterable<Sale> findAll() {
        List<Sale> all = this.saleService.findAll();
        return all;
    }
}
