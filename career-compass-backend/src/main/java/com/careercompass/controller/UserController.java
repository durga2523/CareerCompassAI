package com.careercompass.controller;

import com.careercompass.dto.LoginRequest;
import com.careercompass.dto.LoginResponse;
import com.careercompass.entity.User;
import com.careercompass.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public  User registerUser(@Valid @RequestBody User user) {

        return userService.registerUser(user);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {

        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @Valid @RequestBody User user) {

        return userService.updateUser(id, user);
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return "User deleted successfully!";
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());

    }


    //login

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {

        return userService.login(loginRequest);
    }
}


