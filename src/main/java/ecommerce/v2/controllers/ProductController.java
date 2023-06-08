package ecommerce.v2.controllers;

import ecommerce.v2.configurations.components.Response;
import ecommerce.v2.models.dto.ProductDto;
import ecommerce.v2.models.entities.Product;
import ecommerce.v2.services.ProductService;
import ecommerce.v2.valids.groups.GroupProductCreate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    private ModelMapper modelMapper;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    private Response<Product, ProductDto> response;

    @Autowired
    public void setResponse(Response<Product, ProductDto> response) {
        this.response = response;
    }
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody ProductDto productDto) {
        return this.response.create(
                (entity) -> this.productService.create(entity),
                this.modelMapper,
                Product.class,
                productDto,
                GroupProductCreate.class);
    }
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public Iterable<Product> findAll() {
        List<Product> all = this.productService.findAll();
        return all;
    }
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product findOneById(@PathVariable("id") String id) {
        Product oneById = this.productService.findOneById(id);
        return oneById;
    }
}
