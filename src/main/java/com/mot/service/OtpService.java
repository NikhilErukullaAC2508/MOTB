package com.mot.service;

import org.springframework.stereotype.Service;

@Service
public interface OtpService {
	 boolean sendOtpByEmail(String toEmail);

	 boolean verifyOtp(String email, String enteredOtp);

}
