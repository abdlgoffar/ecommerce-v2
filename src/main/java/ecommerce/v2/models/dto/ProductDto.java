package ecommerce.v2.models.dto;

import ecommerce.v2.valids.groups.GroupCartCreate;
import ecommerce.v2.valids.groups.GroupProductCreate;
import ecommerce.v2.valids.groups.GroupSaleProductCreate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class ProductDto {
        @NotBlank(message = "product id is required", groups = {
                        GroupCartCreate.class,
                GroupSaleProductCreate.class
        })
        @Getter
        @Setter
        private String id;
        @NotBlank(message = "product name is required", groups = {
                        GroupProductCreate.class
        })
        @Getter
        @Setter
        private String name;
        @NotNull(message = "product price is required", groups = {
                        GroupProductCreate.class
        })
        @Getter
        @Setter
        private BigDecimal price;
        @NotNull(message = "product stock is required", groups = {
                        GroupProductCreate.class
        })
        @Getter
        @Setter
        private Double stock;
        @Valid
        @NotNull(message = "product sold is required", groups = {
                GroupProductCreate.class
        })
        @Getter
        @Setter
        private SoldDto sold;
        @Valid
        @NotNull(message = "product description is required", groups = {
                        GroupProductCreate.class
        })
        @Getter
        @Setter
        private DescriptionDto description;
        @Valid
        @NotNull(message = "product category is required", groups = {
                GroupProductCreate.class,
                GroupCartCreate.class
        })
        @Getter
        @Setter
        private CategoryDto category;
        @Valid
        @NotNull(message = "product seller is required", groups = {
                        GroupProductCreate.class,
                        GroupCartCreate.class
        })
        @Getter
        @Setter
        private SellerDto[] sellers;
}
