package com.mot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mot.entity.Tutor;
import com.mot.entity.UpdatePasswordForm;

@Service
public interface TutorService {

    Tutor registerTutor(Tutor tutor);
    Tutor getTutorById(Long tutorId);
    List<Tutor> getTutorsByCourses(String course);
    List<Tutor> getTutorsBYCourse(String course);
    Tutor findByEmail(String email);
	 public String login(String email, String password);
	 List<Tutor> getAllTutors();
	 public String updateTutorPassword(UpdatePasswordForm form);
	public void save(Tutor tutor);
	 List<Long> getTutorIds();
	 List<String> getTutorCourses(Long tutorId);
	  long getTutorsCount();
	  Tutor updateTutor(Long id, Tutor updatedTutor);
	List<Tutor> findAll();
	boolean authenticateTutor(String email, String password);
	Long authenticateAndGetId(String email, String password);
	 void deleteTutor(Long id);
	boolean existsById(Long id);
	void deleteById(Long id);
	
	
	 List<Tutor> getTutorsByFirstName(String firstName);
    
}

 