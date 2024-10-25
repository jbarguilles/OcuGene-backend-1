package com.ocugene.service;

import com.ocugene.entity.User;
import com.ocugene.entity.requests.AddUserRequest;
import com.ocugene.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(AddUserRequest addUserRequest){

        return userRepository.save(addUserRequest.mapToUser());
    }

}
