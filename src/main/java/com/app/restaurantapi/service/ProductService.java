package com.app.restaurantapi.service;

import com.app.restaurantapi.entity.Product;
import com.app.restaurantapi.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> findAllActiveProducts() {
        return productRepository.findAllActiveProducts();
    }
}
