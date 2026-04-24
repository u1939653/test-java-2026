package com.springboot.test.application.port.out;

import com.springboot.test.domain.model.Prices;

import java.time.LocalDateTime;

public interface ReadPricesPort {
    Prices findBrandProductPriceByDate(Integer brandId, Integer productId, LocalDateTime date);
}
