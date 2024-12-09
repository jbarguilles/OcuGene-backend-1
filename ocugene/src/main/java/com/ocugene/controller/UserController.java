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
    public ResponseEntity<String> forgotPassword(@RequestParam String email){
        userService.forgotPassword(email);

        // Using String.format for string interpolation
        return ResponseEntity.ok(String.format("An email has been sent to %s", email));
    }

    @PostMapping("/verify-user-using-code")
    public int verifyuserViaCode(@RequestParam String code){

        //this will return the corresponding user id of the user that requested for forgotten password reset
        return userService.verifyUserUsingCode(code);
    }

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody User user){
        Optional<User> tempUser = userService.getUserByUsername(user.getUsername());

        if(tempUser.isPresent()) {
            tempUser.get().setUserPassword(user.getUserPassword());
            userService.saveUser(tempUser.get());
        }

        return ResponseEntity.ok( "success");
    }
}
