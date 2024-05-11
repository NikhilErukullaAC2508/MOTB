package com.mot.repo;

import com.mot.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepository extends JpaRepository<Pay, Long> {

    Pay findTopByOrderByIdDesc();
}
