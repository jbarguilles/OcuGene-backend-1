package com.ocugene.controller;

import com.ocugene.entity.User;
import com.ocugene.entity.requests.AddUserRequest;
import com.ocugene.service.UserService;
import com.ocugene.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = {"/user"})
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() {return ResponseEntity.ok(userService.getAllUsers());}

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest addUserRequest) {
        return ResponseEntity.ok(userService.addUser(addUserRequest));
    }

}
