package com.ocugene.service;

import com.ocugene.entity.Request;
import com.ocugene.entity.requests.AddRequestRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RequestService {
    public List<Request> getAllRequests();

    Request addRequest(AddRequestRequest addRequestRequest);

    Optional<Request> updateStatus(int id, String status);
}
