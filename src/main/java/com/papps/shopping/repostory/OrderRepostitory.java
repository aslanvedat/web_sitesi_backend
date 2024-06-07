package com.papps.shopping.repostory;

import com.papps.shopping.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepostitory extends JpaRepository<Order, Long> {
}
