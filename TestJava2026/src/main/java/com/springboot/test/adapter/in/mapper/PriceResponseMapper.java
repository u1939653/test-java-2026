package com.springboot.test.adapter.in.mapper;


import com.springboot.test.adapter.in.dto.PriceResponse;
import com.springboot.test.domain.model.Prices;
import org.springframework.stereotype.Component;

@Component
public class PriceResponseMapper {
    public PriceResponse toResponse(Prices price) {
        PriceResponse response = null;
        if ( price != null ) {
            response = PriceResponse.builder()
                .brandId( price.getBrandId() )
                .productId( price.getProductId() )
                .startDate( price.getStartDate() )
                .endDate( price.getEndDate() )
                .price( price.getPrice() )
                .build();
        }

        return response;
    }
}
