package ecommerce.v2.models.dto;

import ecommerce.v2.valids.groups.GroupCartCreate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class CartDto {

        @Getter
        @Setter
        private String id;
        @NotBlank(message = "cart name is required", groups = {
                        GroupCartCreate.class
        })
        @Getter
        @Setter
        private String name;

        @Valid
        @NotNull(message = "cart user is required", groups = {
                        GroupCartCreate.class
        })
        @Getter
        @Setter
        private UserDto user;
        @Valid
        @Getter
        @Setter
        private ProductDto[] products;
}
