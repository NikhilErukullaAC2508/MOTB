package com.mot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mot.entity.Admin;
import com.mot.entity.Tutor;
import com.mot.entity.UpdatePasswordForm;
import com.mot.exception.TutorNotFoundException;
import com.mot.repo.TutorRepository;

@Service
public class TutorServiceImpl implements TutorService {
     @Autowired
    private  TutorRepository tutorRepository;
    @Override
    public Tutor registerTutor(Tutor tutor) {
    	
    	
        return tutorRepository.save(tutor);
    }
    
    @Override
    public Tutor getTutorById(Long tutorId) {
        return tutorRepository.findById(tutorId).orElse(null);
    }
    @Override
    public List<Tutor> getTutorsByCourses(String course) {
        return tutorRepository.findByCourses(course);
    }
 
    public String login(String email, String password) {
        Tutor tutor = tutorRepository.findByEmailAndPassword(email, password);
        if (tutor != null ){
            return "login success";
        }
        return "check email and password"; 
    }

	@Override
	public Tutor findByEmail(String email) {
		
		return null;
	}
	 @Override
	    public List<Tutor> getAllTutors() {
	        return tutorRepository.findAll();
	    }
	 @Override
	    public String updateTutorPassword(UpdatePasswordForm form) {
	        Tutor tutor = tutorRepository.findByEmail(form.getEmail());
	        if (tutor != null) {
	            tutor.setPassword(form.getPassword());
	            tutor.setConfirmPassword(form.getConfirmPassword());
	            tutorRepository.save(tutor);
	            return "Password updated successfully";
	        } else {
	            return "Tutor not found with email: ";
	        }
	    }

	@Override
	public void save(Tutor tutor) {
		
		
	}
	 @Override
	    public List<Long> getTutorIds() {
	        return tutorRepository.findAllIds();
	    }
//	 @Override
//	    public List<String> getCoursesForTutor(Long tutorId) {
//	        Tutor tutor = tutorRepository.findById(tutorId).orElse(null);
//	        if (tutor != null) {
//	            return tutor.getCourses();
//	        }
//	        return null; // or throw exception, handle as needed
//	    }
	  @Override
	    public List<String> getTutorCourses(Long tutorId) {
	        Tutor tutor = tutorRepository.findById(tutorId).orElse(null);
	        return tutor != null ? tutor.getCourses() : null;
	    }
	  @Override
	    public long getTutorsCount() {
	        return tutorRepository.count();
	    }

	@Override
	public Tutor updateTutor(Long id, Tutor updatedTutor) {
		updatedTutor.setId(id);
		return tutorRepository.save(updatedTutor);
	}

	@Override
	public List<Tutor> getTutorsBYCourse(String course) {
		List<Tutor> tutors=tutorRepository.findAll();
		
		return tutors.stream()
                .filter(tutor -> tutor.getCourses().contains(course))
                .collect(Collectors.toList());
	}

	@Override
	public List<Tutor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public boolean authenticateTutor(String email, String password) {
        Tutor tutor = tutorRepository.findByEmail(email);
        
        return tutor != null && tutor.getPassword().equals(password);
    }

    @Override
    public Long authenticateAndGetId(String email, String password) {
        Tutor tutor = tutorRepository.findByEmail(email);
        
        if (tutor != null && tutor.getPassword().equals(password)) {
            return tutor.getId();
        } else {
            return null;
        }
    }

    @Override
    public void deleteTutor(Long id) {
        // Check if tutor exists
        Tutor tutor = tutorRepository.findById(id)
                                     .orElseThrow(() -> new TutorNotFoundException("Tutor with id " + id + " not found"));

        // Delete tutor
        tutorRepository.deleteById(tutor);
    }

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteById(Long id) 
	{
	   tutorRepository.deleteById(id);	
	}
	
	
	
	 @Override
	    public List<Tutor> getTutorsByFirstName(String firstName) {
	        return tutorRepository.findByFirstName(firstName);
	    }
	
}

