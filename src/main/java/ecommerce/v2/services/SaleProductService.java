package ecommerce.v2.services;

import ecommerce.v2.models.entities.SaleProduct;

import java.util.List;

public interface SaleProductService {
    public abstract SaleProduct create(SaleProduct saleProduct);
    public abstract List<SaleProduct> findAll();
    public abstract SaleProduct findOneById(String id);
}
