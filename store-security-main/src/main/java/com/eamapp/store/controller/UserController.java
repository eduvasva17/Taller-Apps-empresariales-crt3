package com.eamapp.store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eamapp.store.model.entity.User;
import com.eamapp.store.model.response.UserResponseRest;
import com.eamapp.store.model.service.IUserService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping("/users")
    public ResponseEntity<UserResponseRest> getAllUsers(){
        return userService.getAllUsers();
    }

    // Get user by id
    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseRest> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    // Save user
    @PostMapping("/users")
    public ResponseEntity<UserResponseRest> saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    // Update user
    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponseRest> updateUser(@RequestBody User user, @PathVariable Long id){
        return userService.updateUser(user, id);
    }
    
    // Delete user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserResponseRest> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
