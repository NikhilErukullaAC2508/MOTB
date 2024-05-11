package com.mot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mot.service.OtpService;
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/api/users")
@Controller
public class OtpController {

    @Autowired
    private OtpService userService;

    @GetMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestParam String email) {
        try {
            boolean result = userService.sendOtpByEmail(email);
            if (result) {
                return ResponseEntity.ok("OTP sent successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send OTP");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String enteredOtp) {
        boolean isOtpValid = userService.verifyOtp(email, enteredOtp);
        return isOtpValid
                ? ResponseEntity.ok("OTP matched")
                : ResponseEntity.badRequest().body("Invalid OTP");
    }

	

}
