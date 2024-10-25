package com.ocugene.entity.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ocugene.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {

    @JsonProperty("username")
    private String username;

    @JsonProperty("user_password")
    private String userPassword;

    @JsonProperty("user_role")
    private String userRole;

    public User mapToUser(){
        User user = new User();

        user.setUsername(this.username);
        user.setUserPassword(this.userPassword);
        user.setUserRole(this.userRole);

        return user;
    }

}
