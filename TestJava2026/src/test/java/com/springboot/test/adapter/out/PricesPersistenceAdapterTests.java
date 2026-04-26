package com.springboot.test.adapter.out;

import com.springboot.test.adapter.out.entity.PricesEntity;
import com.springboot.test.adapter.out.repository.PricesRepository;
import com.springboot.test.domain.model.CurrencyType;
import com.springboot.test.domain.model.Prices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PricesPersistenceAdapterTests {

    @Mock
    private PricesRepository pricesRepository;

    @InjectMocks
    private PricesPersistenceAdapter adapter;

    private static final Integer BRAND_ID = 1;
    private static final Integer PRODUCT_ID = 35455;
    private static final LocalDateTime DATE = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
    private static final LocalDateTime START = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
    private static final LocalDateTime END   = LocalDateTime.of(2020, 12, 31, 23, 59, 59);

    @Test
    void findBrandProductPriceByDate_whenFound_mapsToDomain() {
        PricesEntity entity = new PricesEntity();
        entity.setId(1);
        entity.setBrandId(BRAND_ID);
        entity.setProductId(PRODUCT_ID);
        entity.setStartDate(START);
        entity.setEndDate(END);
        entity.setPriority(0);
        entity.setPrice(35.50);
        entity.setCurrency("EUR");
        when(pricesRepository.findOneByBrandIdAndProductIdAndDate(BRAND_ID, PRODUCT_ID, DATE))
                .thenReturn(Optional.of(entity));

        Prices result = adapter.findBrandProductPriceByDate(BRAND_ID, PRODUCT_ID, DATE);

        assertThat(result).isNotNull();
        assertThat(result.getPriceId()).isEqualTo(1);
        assertThat(result.getBrandId()).isEqualTo(BRAND_ID);
        assertThat(result.getProductId()).isEqualTo(PRODUCT_ID);
        assertThat(result.getStartDate()).isEqualTo(START);
        assertThat(result.getEndDate()).isEqualTo(END);
        assertThat(result.getPriority()).isEqualTo(0);
        assertThat(result.getPrice()).isEqualTo(35.50);
        assertThat(result.getCurrency()).isEqualTo(CurrencyType.EUR);
    }

    @Test
    void findBrandProductPriceByDate_whenNotFound_returnsNull() {
        when(pricesRepository.findOneByBrandIdAndProductIdAndDate(BRAND_ID, PRODUCT_ID, DATE))
                .thenReturn(Optional.empty());

        Prices result = adapter.findBrandProductPriceByDate(BRAND_ID, PRODUCT_ID, DATE);

        assertThat(result).isNull();
    }
}

