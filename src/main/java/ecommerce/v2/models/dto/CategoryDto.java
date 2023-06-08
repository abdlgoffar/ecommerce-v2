package ecommerce.v2.models.dto;

import ecommerce.v2.valids.groups.GroupCartCreate;
import ecommerce.v2.valids.groups.GroupCategoryCreate;
import ecommerce.v2.valids.groups.GroupProductCreate;
import ecommerce.v2.valids.groups.GroupSellerCreate;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


public class CategoryDto {
    @NotBlank(
            message = "category id is required",
            groups = {
                    GroupProductCreate.class,
                    GroupCartCreate.class,
                    GroupSellerCreate.class
            })
    @Getter @Setter
    private String id;
    @NotBlank(
            message = "category name is required",
            groups = {
                    GroupCategoryCreate.class
            })
    @Getter @Setter
    private String name;

    @Getter @Setter
    private ImgDto img;
}
