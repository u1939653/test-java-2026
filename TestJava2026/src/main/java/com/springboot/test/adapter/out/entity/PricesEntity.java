package com.springboot.test.adapter.out.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Data
public class PricesEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column( name = "PRICE_ID", nullable = false, unique = true )
     private Integer id;

     @Column( name = "BRAND_ID", nullable = false )
     private Integer brandId;

     @Column( name = "PRODUCT_ID", nullable = false )
     private Integer productId;

     @Column( name = "START_DATE", nullable = false )
     private LocalDateTime startDate;

     @Column( name = "END_DATE" )
     private LocalDateTime endDate;

     @Column( name = "PRIORITY", nullable = false )
     private Integer priority;

     @Column( name = "PRICE", nullable = false )
     private Double price;

     @Column( name = "CURRENCY", nullable = false )
     private String currency;
}
