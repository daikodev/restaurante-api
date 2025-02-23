package com.app.restaurantapi.repository;

import com.app.restaurantapi.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

    @Query("SELECT s FROM Sale s JOIN FETCH s.product WHERE s.code = :code")
    Optional<Sale> findSaleByCode(@Param("code") String code);


}
