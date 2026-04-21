package com.springboot.test.application.port.out;

import com.springboot.test.domain.model.Prices;

import java.time.LocalDateTime;
import java.util.List;

public interface ReadPricesPort {
    List<Prices> findBrandProductPricesByDate(Integer brandId, Integer productId, LocalDateTime date);
}
