package ecommerce.v2.models.dto;

import ecommerce.v2.valids.groups.GroupProductCreate;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class SoldDto {
    @NotBlank(
            message = "sold id is required",
            groups = {
                    GroupProductCreate.class
            }
    )
    @Getter
    @Setter
    private String id;
    @Getter @Setter
    private Double amount;
}
