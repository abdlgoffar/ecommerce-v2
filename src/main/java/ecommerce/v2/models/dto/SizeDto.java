package ecommerce.v2.models.dto;

import ecommerce.v2.valids.groups.GroupDescriptionCreate;
import ecommerce.v2.valids.groups.GroupSizeCreate;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class SizeDto {
    @NotBlank(
            message = "size id is required",
            groups = {
                    GroupDescriptionCreate.class
            }
    )
    @Getter
    @Setter
    private String id;
    @NotBlank(
            message = "size name is required",
            groups = {
                    GroupSizeCreate.class
            }
    )
    @Getter @Setter
    private String name;
}
