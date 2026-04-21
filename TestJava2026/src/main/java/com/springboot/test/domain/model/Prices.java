package com.springboot.test.domain.model;

import java.time.LocalDateTime;

public class Prices {
    private Integer priceId;
    private Integer brandId;
    private Integer productId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priority;
    private Double price;
    private CurrencyType currency;

     public Prices(Integer priceId, Integer brandId, Integer productId, LocalDateTime startDate, LocalDateTime endDate, Integer priority, Double price, CurrencyType currency) {
        this.priceId = priceId;
        this.brandId = brandId;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    public Integer getPriceId() { return priceId; }
    public Integer getBrandId() { return brandId; }
    public Integer getProductId() { return productId; }
    public LocalDateTime getStartDate() { return startDate; }
    public LocalDateTime getEndDate() { return endDate; }
    public Integer getPriority() { return priority; }
    public Double getPrice() { return price; }
    public CurrencyType getCurrency() { return currency; }
}
