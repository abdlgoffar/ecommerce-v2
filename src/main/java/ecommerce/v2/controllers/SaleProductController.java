package ecommerce.v2.controllers;

import ecommerce.v2.configurations.components.Response;
import ecommerce.v2.models.dto.SaleProductDto;
import ecommerce.v2.models.entities.SaleProduct;
import ecommerce.v2.services.SaleProductService;
import ecommerce.v2.valids.groups.GroupSaleProductCreate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaleProductController {
    private SaleProductService saleProductService;
    @Autowired
    public void setSaleProductService(SaleProductService saleProductService) {
        this.saleProductService = saleProductService;
    }
    private ModelMapper modelMapper;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    private Response<SaleProduct, SaleProductDto> response;
    @Autowired
    public void setResponse(Response<SaleProduct, SaleProductDto> response) {
        this.response = response;
    }
    @RequestMapping(value = "/sales-products", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody SaleProductDto saleProductDto) {
        return this.response.create(
                (entity) -> this.saleProductService.create(entity),
                this.modelMapper,
                SaleProduct.class,
                saleProductDto,
                GroupSaleProductCreate.class);
    }
    @RequestMapping(value = "/sales-products", method = RequestMethod.GET)
    public Iterable<SaleProduct> findAll() {
        List<SaleProduct> all = this.saleProductService.findAll();
        return all;
    }
}
