package com.mot.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mot.entity.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
     LoginEntity findByEmailAndPassword(String email, String password);

	boolean existsByEmail(String email);

//	LoginEntity save(String email, String password);
}
