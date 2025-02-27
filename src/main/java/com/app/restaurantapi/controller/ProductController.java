package com.app.restaurantapi.controller;

import com.app.restaurantapi.entity.Product;
import com.app.restaurantapi.repository.ProductRepository;
import com.app.restaurantapi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public List<Product> findAllActiveProducts() {
        return productService.findAllActiveProducts();
    }


    @GetMapping("/code/{code}")
    public List<Product> findProductByCode(@PathVariable String code) {
        return productService.findProductByCode(code);
    }

    @GetMapping("/in-stock")
    public List<Product> findProductsForSpinner() {
        return productService.findProductsForSpinner();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestParam String code, @RequestParam String description, @RequestParam String unitOfMeasure, @RequestParam Double price, @RequestParam Integer stock, @RequestParam Boolean status) {

        if (productService.existsByCode(code)) {
            return ResponseEntity.status(409).build();
        }

        Product product = new Product();
        product.setCode(code);
        product.setDescription(description);
        product.setUnitOfMeasure(unitOfMeasure);
        product.setPrice(price);
        product.setStock(stock);
        product.setStatus(status);

        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @PatchMapping("/update/{id}")
    public Product updateProduct(@PathVariable int id, @RequestParam String code, @RequestParam String description, @RequestParam String unitOfMeasure, @RequestParam Double price, @RequestParam Integer stock, @RequestParam Boolean status) {

        Product product = new Product();
        product.setCode(code);
        product.setDescription(description);
        product.setUnitOfMeasure(unitOfMeasure);
        product.setPrice(price);
        product.setStock(stock);
        product.setStatus(status);

        return productService.updateProduct(id, product);
    }

    @PatchMapping("/delete/{id}")
    public Product deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}