package com.springboot.test.application.port.in;

import com.springboot.test.domain.model.Prices;
import java.time.LocalDateTime;

public interface GetBrandProductPriceUseCase {
    Prices getBrandProductPrice(Integer brandId, Integer productId, LocalDateTime date);
}
