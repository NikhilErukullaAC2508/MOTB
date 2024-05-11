package com.mot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mot.entity.UpdatePasswordForm;
import com.mot.entity.User;
import com.mot.entity.UserDTO;
import com.mot.repo.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public User userRegister(User user) {
		 User existingUser = userRepository.findByEmail(user.getEmail());
		    if (existingUser != null) {
		    	 throw new RuntimeException("User with this email already exists");
		    }
		    return userRepository.save(user);
		    }

	@Override
	public String updateUserPassword(UpdatePasswordForm form) {
		
		User userEntity = userRepository.findByEmail(form.getEmail());
		if (userEntity !=null) {
			
			userEntity.setPassword(form.getPassword());
			userEntity.setConfirmPassword(form.getConfirmPassword());
			userRepository.save(userEntity);
			
			return "your password is updated successfully";
		}
		return "your password is not updated successfully";

 	}	
	
	
	
	@Override
	public String updateUserPassword1(UpdatePasswordForm form) {
	    User userEntity = userRepository.findByEmail(form.getEmail());
	    if (userEntity != null) {
	        userEntity.setPassword(form.getPassword());
	        userEntity.setConfirmPassword(form.getConfirmPassword());
	        userRepository.save(userEntity);
	 
	        return "Your password has been updated successfully.";
	    } else {
	       
	        return "Email is not registered. Please provide a registered email address.";
	    }
	}
		

	@Override
	public String login(String email, String password) {
		List<User> userEntity = userRepository.findByEmailAndPassword(email, password);
		if (userEntity!=null) {
			return "login success";
		}
		return "check eamil and password";
	}

	@Override
	public List<User> getUsersByCourses(String course) {
		return userRepository.findByCourses(course);
	}

	
    @Override
    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }

    
    
    @Override
    public void updateUser(User updatedUser) {
        userRepository.save(updatedUser);
    }
    
    
	@Override
	public String updateUserPassword(User updatedUser) {
	
		return null;
	}
	 @Override
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
	 
	 @Override
	    public List<Long> getUserIds() {
	        return userRepository.findAllIds();
	    }


	@Override
	public List<User> getUsersByEmailAndPassword(String email, String password) {
		
		return null;
	}
	 
	@Override
	 public List<User> getAccountsByEmailAndPassword(String email, String password) {
	        return userRepository.findByEmailAndPassword(email, password);
	    }
	  @Override
	    public List<User> getUsersByCourse(String course) {
	        List<User> users = userRepository.findAll();
	        return users.stream()
	                    .filter(user -> user.getCourses().contains(course))
	                    .collect(Collectors.toList());
	    }

	@Override
	public List<User> findAll() {
	
		return null;
	}

	@Override
	public long getUsersCount() {
	
		return userRepository.count();
	}
	 @Override
	    public List<String> getAllUserCourseNames() {
	        List<User> users = userRepository.findAll();
	        return users.stream()
	                .flatMap(user -> user.getCourses().stream())
	                .distinct() // Remove duplicates
	                .collect(Collectors.toList());
	    }
	 @Autowired
	 public List<String> getUserCourses() {
	   
	        List<String> userCourses = entityManager.createQuery(
	                "SELECT DISTINCT u.courses FROM User u", String.class)
	                .getResultList();
	        return userCourses;
	    }


	
	
	
	
	
	@Override
	public UserDTO getLatestUser() {
	    User latestUser = userRepository.findTopByOrderByIdDesc().orElse(null);
	    if (latestUser != null) {
	        return new UserDTO(latestUser.getFirstName(), latestUser.getLastName());
	    } else {
	        return null;
	    }
	}
}


