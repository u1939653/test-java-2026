package com.springboot.test.adapter.in.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PricesControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    void getPriceAtDate_2020_06_14_1000() throws Exception {
        this.getPriceAtDate( 1, 35455, LocalDateTime.of(2020, 6, 14, 10, 0, 0), 35.5 );
    }

    @Test
    void getPriceAtDate_2020_06_14_1600() throws Exception {
        this.getPriceAtDate( 1, 35455, LocalDateTime.of(2020, 6, 14, 16, 0, 0), 25.45 );
    }

    @Test
    void getPriceAtDate_2020_06_15_1000() throws Exception {
        this.getPriceAtDate( 1, 35455, LocalDateTime.of(2020, 6, 15, 10, 0, 0), 30.5 );
    }

    @Test
    void getPriceAtDate_2020_06_16_2100() throws Exception {
        this.getPriceAtDate( 1, 35455, LocalDateTime.of(2020, 6, 16, 21, 0, 0), 38.95 );
    }

    private void getPriceAtDate(Integer brandId, Integer productId, LocalDateTime date, Double expectedPrice) throws Exception {
        this.mockMvc
            .perform(
                get("/prices/{brandId}/{productId}", brandId, productId)
                    .param("date", date.toString())
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.brandId").value( brandId ))
            .andExpect(jsonPath("$.productId").value( productId ))
            .andExpect(jsonPath("$.price").value( expectedPrice ));
    }
}
