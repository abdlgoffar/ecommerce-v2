package ecommerce.v2.controllers;

import ecommerce.v2.configurations.components.Response;
import ecommerce.v2.models.dto.UserDto;
import ecommerce.v2.models.entities.User;
import ecommerce.v2.services.UserService;
import ecommerce.v2.valids.groups.GroupUserCreate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    private ModelMapper modelMapper;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    private Response<User, UserDto> response;
    @Autowired
    public void setResponse(Response<User, UserDto> response) {
        this.response = response;
    }
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody UserDto userDto) {
        return this.response.create(
                (entity) -> this.userService.create(entity),
                this.modelMapper,
                User.class,
                userDto,
                GroupUserCreate.class);
    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Iterable<User> findAll() {
        List<User> all = this.userService.findAll();
        return all;
    }
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User findOneById(@PathVariable("id") String id) {
        User oneById = this.userService.findOneById(id);
        return oneById;
    }

}
