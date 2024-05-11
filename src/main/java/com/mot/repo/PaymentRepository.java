package com.mot.repo;

//PaymentRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mot.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
 // You can add custom query methods if needed
}

