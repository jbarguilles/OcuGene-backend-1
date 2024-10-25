package com.ocugene.controller;

import com.ocugene.entity.User;
import com.ocugene.entity.requests.AddUserRequest;
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
    UserServiceImpl userServiceImpl;

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() {return ResponseEntity.ok(userServiceImpl.getAllUsers());}

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest addUserRequest) {
        return ResponseEntity.ok(userServiceImpl.addUser(addUserRequest));
    }

    @GetMapping("/")
    public ResponseEntity<String> default_Home(){ return ResponseEntity.ok("Hello World");}
}
