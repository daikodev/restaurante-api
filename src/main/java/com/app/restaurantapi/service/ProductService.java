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
        return productRepository.findAllActiveProducts();
    }

    public List<Product> findProductByCode(String code) {
        return productRepository.findProductByCode(code);
    }

    public List<Product> findProductsForSpinner() {
        return productRepository.findProductsForSpinner();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(int id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow(null);

        if (existingProduct != null) {
            existingProduct.setCode(product.getCode());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setUnitOfMeasure(product.getUnitOfMeasure());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStock(product.getStock());
            existingProduct.setStatus(product.getStatus());
        }

        return productRepository.save(existingProduct);
    }

    public Product deleteProduct(int id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(null);
        if (existingProduct != null) {
            existingProduct.setStatus(false);
        }
        return productRepository.save(existingProduct);
    }

    public boolean existsByCode(String code) {
        return productRepository.existsByCode(code);
    }
}
