package com.springboot.test.domain.service;

import com.springboot.test.domain.model.Prices;
import java.util.Comparator;
import java.util.List;

public class PricesDomainService {
    public Prices getPriceWithHighestPriority(List<Prices> prices) {
        Prices result = null;
        if ( prices!=null && !prices.isEmpty() ) {
            result = prices.stream().max( Comparator.comparingInt(Prices::getPriority) ).get();
        }

        return result;
    }
}
