package ecommerce.v2.models.dto;

import ecommerce.v2.valids.groups.GroupColorCreate;
import ecommerce.v2.valids.groups.GroupDescriptionCreate;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class ColorDto {
    @NotBlank(message = "color id is required", groups = {
            GroupDescriptionCreate.class
    })
    @Getter
    @Setter
    private String id;

    @NotBlank(message = "color name is required", groups = {
            GroupColorCreate.class
    })
    @Getter
    @Setter
    private String name;
}
