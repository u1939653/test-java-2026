package com.springboot.test.adapter.in.controller;

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

    @GetMapping("/prices")
    public ResponseEntity<?> getPriceAtDate( @RequestParam Integer brandId, @RequestParam Integer productId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date ) {
        // TODO: implement
        this.logger.debug("[PricesController][getPriceAtDate] DEBUG: brandId={}, productId={}, date={}", brandId, productId, date.toString());
        return ResponseEntity.ok("TODO");
    }
}
