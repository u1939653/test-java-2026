package com.springboot.test.adapter.out.repository;

import com.springboot.test.adapter.out.entity.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;

@Repository
public interface PricesRepository extends JpaRepository<PricesEntity, Integer> {
    @Query(
        "SELECT p " +
        "FROM PricesEntity p " +
        "WHERE " +
            ":brandId = p.brandId AND" +
            ":productId = p.productId AND " +
            "(:date BETWEEN p.startDate AND p.endDate) " +
        "ORDER BY p.priority DESC " +
        "LIMIT 1")
    PricesEntity findOneByBrandIdAndProductIdAndDate(Integer brandId, Integer productId, LocalDateTime date);
}
