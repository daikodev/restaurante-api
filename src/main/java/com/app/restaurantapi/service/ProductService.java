package com.app.restaurantapi.service;

import com.app.restaurantapi.entity.Product;
import com.app.restaurantapi.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllActiveProducts() {
        return productRepository.findAll();
    }


}
