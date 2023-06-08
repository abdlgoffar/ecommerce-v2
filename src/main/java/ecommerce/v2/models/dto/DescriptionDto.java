package ecommerce.v2.models.dto;



import ecommerce.v2.valids.groups.GroupDescriptionCreate;
import ecommerce.v2.valids.groups.GroupProductCreate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class DescriptionDto {
        @NotNull(message = "description id is required", groups = {
                        GroupProductCreate.class
        })
        @Getter
        @Setter
        private String id;
        @Valid
        @NotNull(message = "description size is required", groups = {
                        GroupDescriptionCreate.class
        })
        @Getter
        @Setter
        private SizeDto[] sizes;
        @Valid
        @NotNull(message = "description color is required", groups = {
                        GroupDescriptionCreate.class
        })
        @Getter
        @Setter
        private ColorDto[] colors;
}
