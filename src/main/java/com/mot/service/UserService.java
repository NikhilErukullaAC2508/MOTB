package com.mot.service;

import java.util.List;

import com.mot.entity.UpdatePasswordForm;
import com.mot.entity.User;
import com.mot.entity.UserDTO;

public interface UserService {
	User userRegister(User user);

	String updateUserPassword(User updatedUser);

	public String login(String email, String password);


	List<User> getUsersByCourses(String course);
	  List<User> getUsersByCourse(String course);

	User getUserById(Long userId);

	String updateUserPassword(UpdatePasswordForm form);

	void updateUser(User updatedUser);
	  List<User> getAllUsers();
	  
	   List<Long> getUserIds();

	List<User> getUsersByEmailAndPassword(String email, String password);

	List<User> getAccountsByEmailAndPassword(String email, String password);

	List<User> findAll();

	long getUsersCount();
	  List<String> getAllUserCourseNames();
	  public List<String> getUserCourses();

	UserDTO getLatestUser();

	String updateUserPassword1(UpdatePasswordForm form);




	  
	  

}

