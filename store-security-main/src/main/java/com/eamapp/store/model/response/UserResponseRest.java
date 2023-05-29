package com.eamapp.store.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseRest extends ResponseRest{
    private UserResponse userResponse = new UserResponse();
}
