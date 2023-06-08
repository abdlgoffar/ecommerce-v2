package ecommerce.v2.models.dto;

import ecommerce.v2.valids.groups.GroupSaleCreate;
import ecommerce.v2.valids.groups.GroupSaleProductCreate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class SaleDto {
    @NotNull(
            message = "sale id is required",
            groups = {
                    GroupSaleProductCreate.class
            }
    )

    @Getter @Setter
    private String id;
    @NotBlank(
            message = "sale name is required",
            groups = {
                    GroupSaleCreate.class
            })
    @Getter @Setter
    private String name;
    @Valid
    @NotNull(
            message = "sale user is required",
            groups = {
                    GroupSaleCreate.class
            })
    @Getter @Setter
    private UserDto user;
}
