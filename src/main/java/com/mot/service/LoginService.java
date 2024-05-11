package com.mot.service;

import java.util.List;

import com.mot.entity.LoginEntity;

public interface LoginService {
//	LoginEntity register(String email,String password);
    List<LoginEntity> getAllUsers();
    LoginEntity loginUser(String email, String password);
    LoginEntity register(String email, String password);

}
