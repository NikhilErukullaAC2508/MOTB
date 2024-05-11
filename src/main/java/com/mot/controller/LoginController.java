package com.mot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mot.entity.LoginEntity;
import com.mot.service.LoginService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/api/users")
public class LoginController {

    @Autowired
    private LoginService userService;

    @GetMapping("/get")
    public ResponseEntity<List<LoginEntity>> getAllUsers() {
        List<LoginEntity> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest request) {
        try {
            LoginEntity user = userService.loginUser(request.getEmail(), request.getPassword());
            if (user == null) {
                // Log failed login attempt
                System.out.println("Login failed for email: " + request.getEmail());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            // Log any exceptions that occur during login
            System.err.println("Exception during login: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequest request) {
        try {
            LoginEntity newUser = userService.register(request.getEmail(), request.getPassword());
            if (newUser == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with this email already exists");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (Exception e) {
            // Log any exceptions that occur during registration
            System.err.println("Exception during registration: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    // Define UserLoginRequest class
    static class UserLoginRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // Define UserRegisterRequest class
    static class UserRegisterRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}


//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.Login.entity.LoginEntity;
//import com.Login.service.LoginService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/users")
//public class LoginController {
//
//    @Autowired
//    private LoginService userService;
//
//    @GetMapping("/get")
//    public ResponseEntity<List<LoginEntity>> getAllUsers() {
//        List<LoginEntity> users = userService.getAllUsers();
//        return ResponseEntity.ok(users);
//    }
//
////    @PostMapping("/login")
////    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest request) {
////        LoginEntity user = userService.loginUser(request.getEmail(), request.getPassword());
////        if (user == null) {
////            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
////        }
////        return ResponseEntity.ok(user);
////    }
////    @PostMapping("/login")
////    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest request) {
////        // Log received email and password
////        System.out.println("Received email: " + request.getEmail());
////        System.out.println("Received password: " + request.getPassword());
////
////        // Your existing logic here
////    }
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest request) {
//        LoginEntity user = userService.loginUser(request.getEmail(), request.getPassword());
//        if (user == null) {
//            // Log failed login attempt
//            System.out.println("Login failed for email: " + request.getEmail());
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//        }
//        // Your existing logic here
//		return ResponseEntity.ok(user) ;
//    }
////    public LoginEntity register(String email, String password) {	
////		return userService.register(email, password);
////	}
//
//    static class UserLoginRequest {
//        private String email;
//        private String password;
//		public String getEmail() {
//			return email;
//		}
//		public void setEmail(String email) {
//			this.email = email;
//		}
//		public String getPassword() {
//			return password;
//		}
//		public void setPassword(String password) {
//			this.password = password;
//		}
//
//        
//    }
//}
//
