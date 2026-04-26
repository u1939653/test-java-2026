package com.springboot.test.application.service;

import com.springboot.test.application.port.out.ReadPricesPort;
import com.springboot.test.domain.model.CurrencyType;
import com.springboot.test.domain.model.Prices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PricesServiceTests {

    @Mock
    private ReadPricesPort readPricesPort;

    @InjectMocks
    private PricesService pricesService;

    private static final Integer BRAND_ID = 1;
    private static final Integer PRODUCT_ID = 35455;
    private static final LocalDateTime DATE = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

    @Test
    void getBrandProductPrice_delegatesToPort_andReturnsResult() {
        Prices expected = new Prices(1, BRAND_ID, PRODUCT_ID,
                LocalDateTime.of(2020, 6, 14, 0, 0, 0),
                LocalDateTime.of(2020, 12, 31, 23, 59, 59),
                0, 35.50, CurrencyType.EUR);
        when(readPricesPort.findBrandProductPriceByDate(BRAND_ID, PRODUCT_ID, DATE)).thenReturn(expected);

        Prices result = pricesService.getBrandProductPrice(BRAND_ID, PRODUCT_ID, DATE);

        assertThat(result).isSameAs(expected);
        verify(readPricesPort, times(1)).findBrandProductPriceByDate(BRAND_ID, PRODUCT_ID, DATE);
    }

    @Test
    void getBrandProductPrice_whenPortReturnsNull_returnsNull() {
        when(readPricesPort.findBrandProductPriceByDate(BRAND_ID, PRODUCT_ID, DATE)).thenReturn(null);

        Prices result = pricesService.getBrandProductPrice(BRAND_ID, PRODUCT_ID, DATE);

        assertThat(result).isNull();
    }
}

