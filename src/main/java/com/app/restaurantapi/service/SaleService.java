package com.app.restaurantapi.service;

import com.app.restaurantapi.entity.Product;
import com.app.restaurantapi.entity.Sale;
import com.app.restaurantapi.repository.ProductRepository;
import com.app.restaurantapi.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    public SaleService(SaleRepository saleRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    public Optional<Sale> findSaleByCode(String code) {
        return saleRepository.findSaleByCode(code);
    }

    public List<Sale> findAllSales() {
        return saleRepository.findAllActiveSales();
    }

    public Sale saveSale(Sale sale) {
        Product product = sale.getProduct();
        product.setStock(product.getStock() - sale.getQuantity());
        productRepository.save(product);

        return saleRepository.save(sale);
    }

    public Sale deleteSale(int id) {
        Sale existingSale = saleRepository.findById(id).orElseThrow(null);
        if (existingSale != null) {
            existingSale.setStatus(false);
        }
        return saleRepository.save(existingSale);
    }

    public boolean existsByCode(String code) {
        return saleRepository.existsByCode(code);
    }
}
