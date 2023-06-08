package ecommerce.v2.services;

import ecommerce.v2.models.entities.Sale;

import java.util.List;

public interface SaleService {
    public abstract Sale create(Sale sale);

    public abstract List<Sale> findAll();

    public abstract Sale findOneById(String id);
}
