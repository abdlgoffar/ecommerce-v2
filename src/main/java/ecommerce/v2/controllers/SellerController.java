package ecommerce.v2.controllers;

import ecommerce.v2.configurations.components.Response;
import ecommerce.v2.models.dto.SellerDto;
import ecommerce.v2.models.entities.Seller;
import ecommerce.v2.services.SellerService;
import ecommerce.v2.valids.groups.GroupSellerCreate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SellerController {
    private SellerService sellerService;
    @Autowired
    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }
    private ModelMapper modelMapper;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    private Response<Seller, SellerDto> response;
    @Autowired
    public void setResponse(Response<Seller, SellerDto> response) {
        this.response = response;
    }
    @RequestMapping(value = "/sellers", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody SellerDto sellerDto) {
        return this.response.create(
                (entity) -> this.sellerService.create(entity),
                this.modelMapper,
                Seller.class,
                sellerDto,
                GroupSellerCreate.class);
    }
    @RequestMapping(value = "/sellers", method = RequestMethod.GET)
    public Iterable<Seller> findAll() {
        List<Seller> all = this.sellerService.findAll();
        return all;
    }

}
