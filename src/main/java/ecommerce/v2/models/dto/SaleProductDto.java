package ecommerce.v2.models.dto;
import ecommerce.v2.valids.groups.GroupSaleProductCreate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class SaleProductDto {
    @Getter @Setter
    private String id;
    @Valid
    @NotNull(
            message = "sale is required",
            groups = {
                    GroupSaleProductCreate.class
            }
    )
    @Getter @Setter
    private SaleDto sale;
    @Valid
    @NotNull(
            message = "product is required",
            groups = {
                    GroupSaleProductCreate.class
            }
    )
    @Getter @Setter
    private ProductDto product;
    @NotNull(
            message = "quantity is required",
            groups = {
                    GroupSaleProductCreate.class
            }
    )
    @Getter @Setter
    private Long quantity;
}
