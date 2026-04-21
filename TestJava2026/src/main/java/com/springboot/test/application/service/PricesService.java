package com.springboot.test.application.service;

import com.springboot.test.application.port.in.GetBrandProductPriceUseCase;
import com.springboot.test.application.port.out.ReadPricesPort;
import com.springboot.test.domain.model.Prices;
import com.springboot.test.domain.service.PricesDomainService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PricesService implements GetBrandProductPriceUseCase {

    private final ReadPricesPort readPricesPort;
    private final PricesDomainService pricesDomainService;

    public PricesService(ReadPricesPort readPricesPort, PricesDomainService pricesDomainService) {
        this.readPricesPort = readPricesPort;
        this.pricesDomainService = pricesDomainService;
    }

    @Override
    public Prices getBrandProductPrice(Integer brandId, Integer productId, LocalDateTime date) {
        List<Prices> pricesForDate = readPricesPort.findBrandProductPricesByDate(brandId, productId, date);
        return this.pricesDomainService.getPriceWithHighestPriority(pricesForDate);
    }
}
