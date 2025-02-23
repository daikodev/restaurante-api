package com.app.restaurantapi.service;

import com.app.restaurantapi.entity.Sale;
import com.app.restaurantapi.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Optional<Sale> findSaleByCode(String code) {
        return saleRepository.findSaleByCode(code);
    }

    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    public Sale saveSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale deleteSale(int id) {
        Sale existingSale = saleRepository.findById(id).orElseThrow(null);
        if (existingSale != null) {
            existingSale.setStatus(false);
        }
        return saleRepository.save(existingSale);
    }
}
