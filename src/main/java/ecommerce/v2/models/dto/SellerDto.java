package ecommerce.v2.models.dto;

import ecommerce.v2.valids.groups.GroupCartCreate;
import ecommerce.v2.valids.groups.GroupProductCreate;
import ecommerce.v2.valids.groups.GroupSellerCreate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


public class SellerDto {

    @NotBlank(
            message = "seller id is required",
            groups = {
                    GroupProductCreate.class,
                    GroupCartCreate.class
            })
    @Getter @Setter
    private String id;
    @NotBlank(
            message = "seller name is required",
            groups = {
                    GroupSellerCreate.class
            })
    @Getter @Setter
    private String name;
    @NotBlank(
            message = "seller email is required",
            groups = {
                    GroupSellerCreate.class
            })
    @Email(
            message = "seller email is not valid",
            groups = {
                    GroupSellerCreate.class
            })
    @Getter @Setter
    private String email;
    @Valid
    @NotNull(
            message = "seller category is required",
            groups = {
                    GroupSellerCreate.class
            }
    )
    @Getter @Setter
    private CategoryDto category;
}
