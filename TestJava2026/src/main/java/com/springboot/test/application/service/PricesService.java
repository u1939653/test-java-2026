package com.springboot.test.application.service;

import com.springboot.test.application.port.in.GetBrandProductPriceUseCase;
import com.springboot.test.application.port.out.ReadPricesPort;
import com.springboot.test.domain.model.Prices;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PricesService implements GetBrandProductPriceUseCase {

    private final ReadPricesPort readPricesPort;

    public PricesService(ReadPricesPort readPricesPort) {
        this.readPricesPort = readPricesPort;
    }

    @Override
    public Prices getBrandProductPrice(Integer brandId, Integer productId, LocalDateTime date) {
        return readPricesPort.findBrandProductPriceByDate(brandId, productId, date);
    }
}
