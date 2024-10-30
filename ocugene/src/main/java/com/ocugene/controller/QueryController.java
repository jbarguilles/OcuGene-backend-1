package com.ocugene.controller;

import com.ocugene.entity.Query;
import com.ocugene.entity.User;
import com.ocugene.entity.requests.AddQueryRequest;
import com.ocugene.entity.requests.AddUserRequest;
import com.ocugene.service.QueryService;
import com.ocugene.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = {"/query"})
public class QueryController {

    @Autowired
    QueryService queryService;

    @PostMapping("/submit")
    public ResponseEntity<Query> addQuery(@RequestBody AddQueryRequest addQueryRequest) {
        return ResponseEntity.ok(queryService.addQuery(addQueryRequest));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Query>> getAllQueries(){
        return ResponseEntity.ok(queryService.getAllQueries());
    }
}
