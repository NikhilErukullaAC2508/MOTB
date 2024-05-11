package com.mot.controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mot.entity.UpdatePasswordForm;
import com.mot.entity.User;
import com.mot.entity.UserDTO;
import com.mot.repo.UserRepository;
import com.mot.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@PostMapping("/user/register")
	public User registerUser(@RequestBody User user) {
		return userService.userRegister(user);
	}

	@PostMapping("/saveCourse")
	public String saveCourse(@RequestBody User us ) {
		Optional<User> user = userRepo.findById(us.getId());

		if (user != null) {

			User u = user.get();
			System.out.println("u is " + us.getCourses());

			List<String> lu = u.getCourses();
			
			for(String l:lu) {
				
				System.out.println(l);
				System.out.println(us.getCourses().get(0).toString());
				System.out.println();
				System.out.println(us.getId()==u.getId());
				if(us.getId()==u.getId() && l.equals(us.getCourses().get(0).toString())) {
					
					
					return "Already Exists";
					
				}
			}

			lu.addAll(us.getCourses());

			u.setCourses(lu);

			userRepo.save(u);

			return "saved";
		}

		return "not saved";
	}

	@PostMapping("/update-password")
	public String updatePassword(@RequestBody UpdatePasswordForm form) {
		return userService.updateUserPassword(form);
	}

	@PostMapping("/loginuser")
	public String login(@RequestBody User loginUser) {
		return userService.login(loginUser.getEmail(), loginUser.getPassword());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Long userId) {
		try {
			User user = userService.getUserById(userId);

			if (user != null) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error retrieving user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/by-email-and-password")
	public ResponseEntity<?> getAccountsByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
		try {
			List<User> users = userService.getAccountsByEmailAndPassword(email, password);

			if (!users.isEmpty()) {
				return new ResponseEntity<>(users, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No accounts found for the given email and password", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error retrieving accounts: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
		try {
			User existingUser = userService.getUserById(userId);

			if (existingUser != null) {
				updatedUser.setId(userId); // Ensure the ID of the updated user is set to the correct value
				userService.updateUser(updatedUser);
				return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error updating user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/by-course/{course}")
	public ResponseEntity<?> getUsersByCourses(@PathVariable String course) {
		try {
			List<User> users = userService.getUsersByCourses(course);

			if (!users.isEmpty()) {
				return new ResponseEntity<>(users, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No users found for the given course", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error retrieving users: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/ids")
	public List<Long> getUserIds() {
		return userService.getUserIds();
	}

	@GetMapping("/api/users")
	public List<User> getUsers(@RequestParam(required = false) String course) {
		List<User> users = userService.findAll();
		if (course != null && !course.isEmpty()) {
			return users.stream().filter(user -> user.getCourses().contains(course)).collect(Collectors.toList());
		}
		return users;
	}

	@GetMapping("/users/count")
	public long getUsersCount() {
		return userService.getUsersCount();
	}
	  @GetMapping("/users-courses")
	    public List<String> getUserCourses() {
	        List<String> userCourses = userService.getUserCourses();
	        return userCourses;
	    }
	  
	  @GetMapping("/latest")
	    public ResponseEntity<UserDTO> getLatestUser() {
	        UserDTO userInfo = userService.getLatestUser();
	        if (userInfo != null) {
	            return ResponseEntity.ok(userInfo);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    
	    
	    
  
	  
	  
	  
}
