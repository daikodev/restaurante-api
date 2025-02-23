package com.app.restaurantapi.controller;

import com.app.restaurantapi.entity.Product;
import com.app.restaurantapi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> findAllActiveProducts() {
        return productService.findAllActiveProducts();
    }

    @GetMapping("/code/{code}")
    public List<String> findProductByCode(@PathVariable String code) {
        return productService.findProductByCode(code);
    }
}
