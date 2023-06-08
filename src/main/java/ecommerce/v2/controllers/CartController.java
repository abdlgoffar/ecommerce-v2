package ecommerce.v2.controllers;

import ecommerce.v2.configurations.components.Response;
import ecommerce.v2.models.dto.CartDto;

import ecommerce.v2.models.entities.Cart;

import ecommerce.v2.services.CartService;
import ecommerce.v2.valids.groups.GroupCartCreate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CartController {
    private CartService cartService;
    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }
    private ModelMapper modelMapper;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    private Response<Cart, CartDto> response;
    @Autowired
    public void setResponse(Response<Cart, CartDto> response) {
        this.response = response;
    }

    @RequestMapping(value = "/carts", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody CartDto cartDto) {
        return this.response.create(
                (entity) -> this.cartService.create(entity),
                this.modelMapper,
                Cart.class,
                cartDto,
                GroupCartCreate.class);
    }
    @RequestMapping(value = "/carts", method = RequestMethod.GET)
    public Iterable<Cart> findAll() {
        List<Cart> all = this.cartService.findAll();
        return all;
    }
    @RequestMapping(value = "/carts/{id}", method = RequestMethod.GET)
    public Cart findOneById(@PathVariable("id") String id) {
        Cart oneById = this.cartService.findOneById(id);
        return oneById;
    }
}
