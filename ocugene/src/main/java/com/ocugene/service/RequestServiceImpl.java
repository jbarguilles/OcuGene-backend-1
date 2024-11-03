package com.ocugene.service;

import com.ocugene.entity.Request;
import com.ocugene.entity.requests.AddRequestRequest;
import com.ocugene.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Override
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public Request addRequest(AddRequestRequest addRequestRequest) {
        return requestRepository.save(addRequestRequest.mapToRequest());
    }

    public Optional<Request> updateStatus(int id, String status) {
        Optional<Request> request = requestRepository.findById(id);
        request.ifPresent(value -> value.setStatus(status));
        requestRepository.save(request.get());
        return request;
    }
}
