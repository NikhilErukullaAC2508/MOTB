package com.mot.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mot.entity.Admin;
import com.mot.entity.Tutor;
import com.mot.entity.UpdatePasswordForm;
import com.mot.repo.TutorRepository;
import com.mot.service.TutorService;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/api-v1")
public class TutorController {
     @Autowired
    private  TutorService tutorService;
     
     @Autowired
     private TutorRepository trepo;

    @PostMapping("/create")
    public ResponseEntity<String> createTutor(@RequestBody Tutor tutor) {
    	
    	Tutor t= trepo.findByEmail(tutor.getEmail());
    	if(t==null) {
    		  try {
    	        	System.out.println(tutor.getCourses());
    	        	
    	            Tutor registeredTutor = tutorService.registerTutor(tutor);
    	            return new ResponseEntity<>("Tutor registered successfully. Tutor ID: " + registeredTutor.getId(), HttpStatus.CREATED);
    	        } catch (Exception e) {
    	            return new ResponseEntity<>("Error registering tutor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    	        }
    		
    	}
    	return new ResponseEntity<>("Already mail is registered: " ,HttpStatus.ALREADY_REPORTED);
      
    }
    
    
    @GetMapping("/{tutorId}") 
    public ResponseEntity<?> getTutorById(@PathVariable Long tutorId) {
        try {
            Tutor tutor = tutorService.getTutorById(tutorId);

            if (tutor != null) {
                return new ResponseEntity<>(tutor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Tutor not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving tutor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/by-course/{course}")
    public ResponseEntity<?> getTutorsByCourse(@PathVariable String course) {
        try {
            List<Tutor> tutors = tutorService.getTutorsByCourses(course);

            if (!tutors.isEmpty()) {
                return new ResponseEntity<>(tutors, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No tutors found for the given course", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving tutors: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @PostMapping("/tutorlogin")
//    public String login(@RequestBody Tutor loginTutor) {
//    	return tutorService.login(loginTutor.getEmail(),loginTutor.getPassword());
//    }
    
    
    
    
    
    @PostMapping("/logintutor")
    public ResponseEntity<?> login(@RequestBody Tutor loginTutor) {
    	boolean isAuthenticated = tutorService.authenticateTutor(loginTutor.getEmail(), loginTutor.getPassword());
    	
    	if (isAuthenticated) {
    		Long Id = tutorService.authenticateAndGetId(loginTutor.getEmail(), loginTutor.getPassword());
    		if (Id != null) {
    			return ResponseEntity.ok(Id);
    		} else {
    			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Retrieving Id");
    		}
    	} else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }
    }   

    
    @GetMapping("/tutors")
    public List<Tutor> getAllTutors() {
        return tutorService.getAllTutors();
    }
   

    @PutMapping("/tutorupdatePassword")
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordForm request) {
        String email = request.getEmail();
        String newPassword = request.getPassword();
        if (email == null || newPassword == null) {
            return ResponseEntity.badRequest().body("Email and newPassword must be provided.");
        }

        String result = tutorService.updateTutorPassword(request);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/tutors/ids")
    public List<Long> getTutorIds() {
        return tutorService.getTutorIds();
    }

//    @GetMapping("/{tutorId}/courses")
//    public List<String> getCoursesForTutor(@PathVariable Long tutorId) {
//        return tutorService.getCoursesForTutor(tutorId);
//    }

    @GetMapping("/tutors/{tutorId}/courses")
    public List<String> getTutorCourses(@PathVariable Long tutorId) {
        return tutorService.getTutorCourses(tutorId);
    }

    
    
    @GetMapping("/by-first-name/{firstName}")
    public ResponseEntity<?> getTutorsByFirstName(@PathVariable String firstName) {
        try {
            List<Tutor> tutors = tutorService.getTutorsByFirstName(firstName);

            if (!tutors.isEmpty()) {
                return new ResponseEntity<>(tutors, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No tutors found for the given first name", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving tutors: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    
    
    @GetMapping("/tutors/count")
    public long getTutorsCount() {
        return tutorService.getTutorsCount();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Long id, @RequestBody Tutor updatedTutor) {
        Tutor updated = tutorService.updateTutor(id, updatedTutor);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("unlikely-arg-type")
	@GetMapping("/api/tutors")
    public List<Tutor> getTutors(@RequestParam(required = false) String course) {
        List<Tutor> tutors = tutorService.findAll(); // Assuming you have a TutorService
        if (course != null && !course.isEmpty()) {
            return tutors.stream()
                    .filter(tutor -> Arrays.asList(tutor.getCourses()).contains(course))
                    .collect(Collectors.toList());
        }
		return tutors;
}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id) {
    	tutorService.deleteById(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
