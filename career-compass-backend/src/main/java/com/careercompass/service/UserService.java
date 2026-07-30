package com.careercompass.service;

import com.careercompass.dto.LoginRequest;
import com.careercompass.dto.LoginResponse;
import com.careercompass.entity.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);

    //login

    LoginResponse login(LoginRequest loginRequest);
}
