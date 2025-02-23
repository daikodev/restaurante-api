package com.app.restaurantapi.controller;

import com.app.restaurantapi.entity.Sale;
import com.app.restaurantapi.service.SaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/{code}")
    public Optional<Sale> findSaleByCode(@PathVariable String code) {
        return saleService.findSaleByCode(code);

    }

    @GetMapping("/all")
    public List<Sale> findAllSales() {
        return saleService.findAllSales();
    }

    @PostMapping("/save")
    public Sale saveSale(@RequestBody Sale sale) {
        return saleService.saveSale(sale);
    }

    @PatchMapping("/delete/{id}")
    public Sale deleteSale(@PathVariable int id) {
        return saleService.deleteSale(id);
    }
}
