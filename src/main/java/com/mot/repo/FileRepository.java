package com.mot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mot.entity.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
    // You can add custom queries if needed
}

