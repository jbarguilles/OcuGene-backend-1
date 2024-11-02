package com.ocugene.controller;

import com.ocugene.entity.Query;
import com.ocugene.entity.Request;
import com.ocugene.entity.requests.AddQueryRequest;
import com.ocugene.entity.requests.AddRequestRequest;
import com.ocugene.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = {"/request"})
public class RequestController {
    @Autowired
    RequestService requestService;

    @GetMapping("/getAllRequests")
    public List<Request> getAllRequests() { return requestService.getAllRequests(); }

    @PostMapping("/addRequest")
    public ResponseEntity<Request> addRequest(@RequestBody AddRequestRequest addRequestRequest) {
        return ResponseEntity.ok(requestService.addRequest(addRequestRequest));
    }
}
