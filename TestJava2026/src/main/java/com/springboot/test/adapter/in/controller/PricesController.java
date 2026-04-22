package com.springboot.test.adapter.in.controller;

import com.springboot.test.adapter.in.dto.PriceResponse;
import com.springboot.test.adapter.in.mapper.PriceResponseMapper;
import com.springboot.test.application.port.in.GetBrandProductPriceUseCase;
import com.springboot.test.domain.model.Prices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class PricesController {
    private Logger logger = LoggerFactory.getLogger(PricesController.class);
    private final GetBrandProductPriceUseCase getBrandProductPriceUseCase;
    private final PriceResponseMapper priceResponseMapper;

    public PricesController(
        GetBrandProductPriceUseCase getBrandProductPriceUseCase,
        PriceResponseMapper priceResponseMapper
    ) {
        this.getBrandProductPriceUseCase = getBrandProductPriceUseCase;
        this.priceResponseMapper = priceResponseMapper;
    }

    @GetMapping("/prices")
    public ResponseEntity<PriceResponse> getPriceAtDate(@RequestParam Integer brandId, @RequestParam Integer productId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date ) {
        this.logger.debug("[PricesController][getPriceAtDate][DEBUG] Start: brandId={}, productId={}, date={}", brandId, productId, date.toString());
        Prices currentPrice = this.getBrandProductPriceUseCase.getBrandProductPrice(brandId, productId, date);
        this.logger.debug("[PricesController][getPriceAtDate][DEBUG] Price found: {}", currentPrice.getPriceId());
        return ResponseEntity.ok(this.priceResponseMapper.toResponse(currentPrice));
    }
}
