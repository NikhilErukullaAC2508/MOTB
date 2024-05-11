package com.mot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mot.entity.AssignTutor;
@Repository
public interface AssignTutorRepository extends JpaRepository<AssignTutor, Long> {

	AssignTutor save(AssignTutor assign_tutor);

	AssignTutor findByEmail(String email);
	
	
	
	
}
