package com.mot.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.mot.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);

	public List<User> findByEmailAndPassword(String email, String password);
	
	

	public List<User> findByCourses(String course);

	  @Query("SELECT u.id FROM User u")
	    List<Long> findAllIds();

	public Optional<User> findTopByOrderByIdDesc();


}


