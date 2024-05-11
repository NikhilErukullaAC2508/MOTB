package com.mot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mot.entity.HelpEntity;

public interface HelpRepository extends JpaRepository<HelpEntity, Long> {
    
}

