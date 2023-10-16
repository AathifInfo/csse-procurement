package com.csse.order.repository;


import com.csse.order.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ContractRepository extends JpaRepository<Contract,Long> {
}
