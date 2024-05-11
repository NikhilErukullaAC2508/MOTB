package com.mot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mot.entity.LoginEntity;
import com.mot.repo.LoginRepository;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository userRepository;

    @Override
    public List<LoginEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public LoginEntity loginUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
    @Override
    public LoginEntity register(String email, String password) {
        // Implement your registration logic here
        // This could involve creating a new user entity and saving it to the database
        // Ensure to handle cases where a user with the provided email already exists
        if (userRepository.existsByEmail(email)) {
            return null; // User already exists
        }
        LoginEntity newUser = new LoginEntity();
        newUser.setEmail(email);
        newUser.setPassword(password);
        return userRepository.save(newUser);
    }
//	@Override
//	public LoginEntity register(String email, String password) {	
//		return userRepository.save(email, password);
//	}
}

