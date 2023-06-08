package ecommerce.v2.models.dto;

import ecommerce.v2.valids.groups.GroupCartCreate;
import ecommerce.v2.valids.groups.GroupSaleCreate;
import ecommerce.v2.valids.groups.GroupUserCreate;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class UserDto {
    @NotBlank(
            message = "user id is required",
            groups = {
                    GroupCartCreate.class,
                    GroupSaleCreate.class
            })
    @Getter @Setter
    private String id;
    @NotBlank(
            message = "username is required",
            groups = {
                    GroupUserCreate.class
            })
    @Getter @Setter
    private String username;
    @NotBlank(
            message = "user email is required",
            groups = {
                    GroupUserCreate.class
            })
    @Getter @Setter
    private String email;
    @NotBlank(
            message = "user password is required",
            groups = {
                    GroupUserCreate.class
            })
    @Getter @Setter
    private String password;
}
