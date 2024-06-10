package com.papps.shopping.repostory;

import com.papps.shopping.entity.StockProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockProductRepository extends JpaRepository<StockProduct, Long> {
}
