package com.eamapp.store.model.service;

import org.springframework.http.ResponseEntity;

import com.eamapp.store.model.entity.User;
import com.eamapp.store.model.response.UserResponseRest;

public interface IUserService {
    public ResponseEntity<UserResponseRest> getAllUsers();
    public ResponseEntity<UserResponseRest> getUserById(Long id);
    public ResponseEntity<UserResponseRest> saveUser(User user);
    public ResponseEntity<UserResponseRest> updateUser(User user, Long id);
    public ResponseEntity<UserResponseRest> deleteUser(Long id);
}
