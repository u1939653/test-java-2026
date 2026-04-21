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
}
