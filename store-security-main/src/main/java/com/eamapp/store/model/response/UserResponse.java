package com.eamapp.store.model.response;

import java.util.List;

import com.eamapp.store.model.entity.User;

import lombok.Data;

@Data
public class UserResponse {
    private List<User> users;
}
