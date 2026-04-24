package com.springboot.test.adapter.out;

import com.springboot.test.adapter.out.entity.PricesEntity;
import com.springboot.test.adapter.out.repository.PricesRepository;
import com.springboot.test.application.port.out.ReadPricesPort;
import com.springboot.test.domain.model.CurrencyType;
import com.springboot.test.domain.model.Prices;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PricesPersistenceAdapter implements ReadPricesPort {
    private PricesRepository pricesRepository;

    public PricesPersistenceAdapter(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public Prices findBrandProductPriceByDate(Integer brandId, Integer productId, LocalDateTime date) {
        Optional<PricesEntity> optPrices = pricesRepository.findOneByBrandIdAndProductIdAndDate(brandId, productId, date);
        return optPrices.isPresent()? toDomain( optPrices.get() ) : null;
    }

    private Prices toDomain( PricesEntity pricesEntity ) {
        Prices prices = new Prices(
            pricesEntity.getId(),
            pricesEntity.getBrandId(),
            pricesEntity.getProductId(),
            pricesEntity.getStartDate(),
            pricesEntity.getEndDate(),
            pricesEntity.getPriority(),
            pricesEntity.getPrice(),
            CurrencyType.valueOf(pricesEntity.getCurrency())
        );
        return prices;
    }
}
