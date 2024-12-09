package com.ocugene.service;

import com.ocugene.entity.User;
import com.ocugene.entity.requests.AddUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List<User> getAllUsers();
    User addUser(AddUserRequest addUserRequest);
    Optional<User> getUserByUsername(String username);
    void forgotPassword(String email);
    int verifyUserUsingCode(String code);
}
