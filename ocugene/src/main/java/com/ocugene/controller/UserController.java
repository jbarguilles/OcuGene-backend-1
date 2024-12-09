package com.ocugene.controller;

import com.ocugene.entity.User;
import com.ocugene.entity.requests.AddUserRequest;
import com.ocugene.service.UserService;
import com.ocugene.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.function.Consumer;

@CrossOrigin
@RestController
@RequestMapping(path = {"/user"})
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() {return ResponseEntity.ok(userService.getAllUsers());}

    @PostMapping("/getUser")
    public ResponseEntity<Map<String, Object>> getUser(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        Optional<User> tempUser = userService.getUserByUsername(user.getUsername());
        if (tempUser.isPresent()) {
            if (Objects.equals(user.getUserPassword(), tempUser.get().getUserPassword())) {
                response.put("success", true);
                response.put("user", tempUser.get());
                return ResponseEntity.ok(response);
            }
        }
        response.put("success", false);
        response.put("message", "Incorrect email or password.");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest addUserRequest) {
        return ResponseEntity.ok(userService.addUser(addUserRequest));
    }

    @GetMapping("/getByUsername")
    public ResponseEntity<User> getUserByUsername(@RequestParam String username){
        return ResponseEntity.ok(userService.getUserByUsername(username).get());
    }

    @GetMapping("/forgot-password")
    public void forgotPassword(@RequestParam String email){
        userService.forgotPassword(email);
    }

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody User user){
        Optional<User> tempUser = userService.getUserByUsername(user.getUsername());
        if(tempUser.isPresent()) {
            tempUser.get().setUserPassword(user.getUserPassword());
        }
        return ResponseEntity.ok("Password changed successfully.");
    }
}
