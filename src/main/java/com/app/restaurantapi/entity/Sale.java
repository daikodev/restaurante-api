package com.app.restaurantapi.entity;

import jakarta.persistence.*;
        import lombok.Setter;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "sale")
public class Sale {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code", length = 10, nullable = false)
    private String code;

    @Column(name = "dni", length = 11, nullable = false)
    private String dni;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "client", length = 100, nullable = false)
    private String client;

    @ManyToOne
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "discount", nullable = false)
    private Boolean discount;

    @Column(name = "status", nullable = false)
    private Boolean status;
}
