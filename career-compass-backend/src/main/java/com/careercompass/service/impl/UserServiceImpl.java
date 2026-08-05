package com.careercompass.service.impl;

import com.careercompass.dto.LoginRequest;
import com.careercompass.dto.LoginResponse;
import com.careercompass.entity.User;
import com.careercompass.repository.UserRepository;
import com.careercompass.service.UserService;
import com.careercompass.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public User registerUser(User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            throw new RuntimeException("Email already exists.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setFullName(user.getFullName());
            existingUser.setEmail(user.getEmail());

            // Encrypt password before updating
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));

            return userRepository.save(existingUser);
        }

        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail());

        if (user != null &&
                passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

            String token = jwtUtil.generateToken(user.getEmail());

            return new LoginResponse(token,  user.getId());
        }

        throw new RuntimeException("Invalid email or password");
    }
}