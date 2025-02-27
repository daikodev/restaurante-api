package com.app.restaurantapi.controller;

import com.app.restaurantapi.entity.Sale;
import com.app.restaurantapi.entity.Product;
import com.app.restaurantapi.service.SaleService;
import com.app.restaurantapi.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;
    private final ProductRepository productRepository;

    public SaleController(SaleService saleService, ProductRepository productRepository) {
        this.saleService = saleService;
        this.productRepository = productRepository;
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
    public ResponseEntity<?> saveSale(@RequestParam String code,
                                   @RequestParam String dni,
                                   @RequestParam String date,
                                   @RequestParam String client,
                                   @RequestParam Integer productId,
                                   @RequestParam Integer quantity,
                                   @RequestParam Double total,
                                   @RequestParam Boolean discount,
                                   @RequestParam Boolean status) throws ParseException {

        if (saleService.existsByCode(code)) {
            return ResponseEntity.status(409).build();
        }

        Sale sale = new Sale();
        sale.setCode(code);
        sale.setDni(dni);
        sale.setDate(date);
        sale.setClient(client);
        Product product = productRepository.findById(productId).orElse(null);
        sale.setProduct(product);
        sale.setQuantity(quantity);
        sale.setDiscount(discount);
        sale.setTotal(total);
        sale.setStatus(status);

        Sale savedSale = saleService.saveSale(sale);
        return ResponseEntity.ok(savedSale);
    }

    @PatchMapping("/delete/{id}")
    public Sale deleteSale(@PathVariable int id) {
        return saleService.deleteSale(id);
    }
}
