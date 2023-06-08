package ecommerce.v2.controllers;

import ecommerce.v2.configurations.components.Response;
import ecommerce.v2.models.dto.CategoryDto;
import ecommerce.v2.models.entities.Category;
import ecommerce.v2.services.CategoryService;
import ecommerce.v2.valids.groups.GroupCategoryCreate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    private ModelMapper modelMapper;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    private Response<Category, CategoryDto> response;
    @Autowired
    public void setResponse(Response<Category, CategoryDto> response) {
        this.response = response;
    }
    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody CategoryDto categoryDto) {
        return this.response.create(
                (entity) -> this.categoryService.create(entity),
                this.modelMapper,
                Category.class,
                categoryDto,
                GroupCategoryCreate.class);
    }
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public Iterable<Category> findAll() {
        List<Category> all = this.categoryService.findAll();
        return all;
    }
}
