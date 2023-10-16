package com.csse.order.repository;

import com.csse.order.entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface QuotationRepository extends JpaRepository<Quotation,Long> {
}
