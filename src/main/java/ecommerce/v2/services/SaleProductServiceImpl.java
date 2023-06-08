package ecommerce.v2.services;

import ecommerce.v2.configurations.components.IDGenerator;

import ecommerce.v2.models.repositories.CostRepository;
import ecommerce.v2.models.repositories.ProductRepository;
import ecommerce.v2.models.repositories.SaleProductRepository;
import ecommerce.v2.models.repositories.SoldRepository;
import ecommerce.v2.models.entities.Cost;
import ecommerce.v2.models.entities.Product;
import ecommerce.v2.models.entities.SaleProduct;
import ecommerce.v2.models.entities.Sold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SaleProductServiceImpl implements SaleProductService{
    private SaleProductRepository saleProductRepository;
    @Autowired
    public void setSaleProductRepository(SaleProductRepository saleProductRepository) {
        this.saleProductRepository = saleProductRepository;
    }
    private CostRepository costRepository;
    @Autowired
    public void setCostRepository(CostRepository costRepository) {
        this.costRepository = costRepository;
    }
    private ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    private SoldRepository soldRepository;
    @Autowired
    public void setSoldRepository(SoldRepository soldRepository) {
        this.soldRepository = soldRepository;
    }

    private IDGenerator idGenerator;
    @Autowired
    public void setIdGenerator(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Transactional
    @Override
    public SaleProduct create(SaleProduct saleProduct) {
        Optional<Product> byId = this.productRepository.findById(saleProduct.getProduct().getId());
        Cost cost = new Cost();
        cost.setId(this.idGenerator.generate());
        saleProduct.setId(this.idGenerator.generate());
        cost.setProduct(new BigDecimal(byId.get().getPrice().doubleValue() * saleProduct.getQuantity().doubleValue()));
        saleProduct.setCost(cost);
        saleProduct.setTotal(new BigDecimal(cost.getProduct().doubleValue() + cost.getService().doubleValue() + cost.getDelivery().doubleValue() + cost.getHandling().doubleValue()));
        this.costRepository.save(cost);
        SaleProduct saveSaleProduct = this.saleProductRepository.save(saleProduct);
        Product productAfterSale = byId.get();
        double stock = byId.get().getStock() - saleProduct.getQuantity().doubleValue();
        productAfterSale.setStock(stock);
        Sold sold = productAfterSale.getSold();
        sold.setAmount(sold.getAmount() + saleProduct.getQuantity());
        this.soldRepository.save(sold);
        this.productRepository.save(productAfterSale);
        return saveSaleProduct;
    }

    @Override
    public List<SaleProduct> findAll() {
        List<SaleProduct>  all = this.saleProductRepository.findAll();
        return all;
    }

    @Override
    public SaleProduct findOneById(String id) {
        Optional<SaleProduct> byId = this.saleProductRepository.findById(id);
        if (byId.isPresent()) {
            SaleProduct saleProduct = byId.get();
            return saleProduct;
        } else {
            return null;
        }
    }
}
