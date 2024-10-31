package com.ocugene.service;

import com.ocugene.entity.User;
import com.ocugene.entity.requests.AddUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    User addUser(AddUserRequest addUserRequest);

}
