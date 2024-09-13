package com.ocugene.controller;

import com.ocugene.entity.User;
import com.ocugene.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() {return ResponseEntity.ok(userService.getAllUsers());}

    @GetMapping("/")
    public ResponseEntity<String> default_Home(){ return ResponseEntity.ok("Hello World");}
}
