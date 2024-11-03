package com.ocugene.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ocugene.entity.Request;
import com.ocugene.entity.requests.AddRequestRequest;
import com.ocugene.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/updateStatus/{requestId}/{status}")
    public ResponseEntity<Optional<Request>> updateStatus(@PathVariable int requestId, @PathVariable String status) {
        System.out.println(status);
        return ResponseEntity.ok(requestService.updateStatus(requestId,status));
    }
}
