package com.mot.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class OtpServiceImpl  implements OtpService{
	
	 @Autowired
	    private JavaMailSender mailSender;

	    // Session storage for OTP (you might want to use a more robust mechanism)
	    private static final Map<String, String> sessionStoredOtps = new HashMap<>();

	    @Override
	    public boolean sendOtpByEmail(String toEmail) {
	        try {
	            String otp = generateOTP();
	            sendEmail(toEmail, "Your OTP for Verification", "Your OTP is: " + otp);
	            sendOtpToSession(toEmail, otp);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    @Override
	    public boolean verifyOtp(String email, String enteredOtp) {
	        String storedOtp = getSessionStoredOtp(email);
	        if (storedOtp != null && enteredOtp.equals(storedOtp)) {
	            clearSessionStoredOtp(email);
	            return true;
	        }
	        return false;
	    }

	    // Other methods...

	    // Session storage methods
	    private String getSessionStoredOtp(String email) {
	        return sessionStoredOtps.get(email);
	    }

	    private void clearSessionStoredOtp(String email) {
	        sessionStoredOtps.remove(email);
	    }

	    private void sendOtpToSession(String email, String otp) {
	        sessionStoredOtps.put(email, otp);
	    }

	    // Method to generate a random 6-digit OTP
	    private String generateOTP() {
	        Random random = new Random();
	        int otp = 100000 + random.nextInt(900000); // Generate a random 6-digit number
	        return String.valueOf(otp);
	    }

	    // Method to send email
	    private void sendEmail(String to, String subject, String body) {
	        try {
	            MimeMessage mimeMessage = mailSender.createMimeMessage();
	            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
	            messageHelper.setTo(to);
	            messageHelper.setSubject(subject);
	            messageHelper.setText(body, true);
	            mailSender.send(mimeMessage);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	
	

}
