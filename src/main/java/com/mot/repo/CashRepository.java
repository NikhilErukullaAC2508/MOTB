package com.mot.repo;

import com.mot.entity.Cash;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Add this annotation
public interface CashRepository extends JpaRepository<Cash, Long> {

	Cash findByAcknowledgment(String acknowledgmentNumber);
    // Your repository methods

	Cash findTopByOrderByIdDesc();
		
}
