package com.springboot.test.adapter.in.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PriceResponse {
    private Integer brandId;
    private Integer productId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
    // TODO: Wouldn't currency make sense too?
}
