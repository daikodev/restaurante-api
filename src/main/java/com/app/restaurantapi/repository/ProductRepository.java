package com.app.restaurantapi.repository;

import com.app.restaurantapi.entity.Product;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.status = true")
    List<Product> findAllActiveProducts();

    @Query("SELECT P FROM Product P WHERE P.code = :code AND P.status = true")
    List<Product> findProductByCode(@Param("code") String code);

}