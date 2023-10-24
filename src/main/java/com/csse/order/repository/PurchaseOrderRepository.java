package com.csse.order.repository;

import com.csse.order.entity.Order;
import com.csse.order.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
