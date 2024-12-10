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

    @JsonProperty("user_type")
    private String userType;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("contactNumber")
    private String contactNumber;

    @JsonProperty("email")
    private String email;

    public User mapToUser(){
        User user = new User();

        user.setUsername(this.username);
        user.setUserPassword(this.userPassword);
        user.setUserType(this.userType);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setContactNumber(this.contactNumber);
        user.setEmail(this.email);

        return user;
    }

}
