package com.mot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mot.entity.Tutor;
@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

	List<Tutor> findByCourses(String course);
	
	   Tutor findByEmail(String email);
	   
	   
	Tutor findByEmailAndPassword(String email, String password);
	

    @Query("SELECT t.id FROM Tutor t")
	List<Long> findAllIds();

    
	void deleteById(Tutor tutor);
	
	List<Tutor> findByFirstName(String firstName);
    
}

