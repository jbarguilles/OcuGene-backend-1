package com.ocugene.service;

import com.ocugene.entity.Request;
import com.ocugene.entity.User;
import com.ocugene.entity.requests.AddRequestRequest;
import com.ocugene.repository.RequestRepository;
import com.ocugene.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    UserRepository userRepository;

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

        if(request.isPresent()){
            Request actualRequest = request.get();
            actualRequest.setStatus(status);

            if(status == "accepted"){
                User user = new User();
                user.setUsername(actualRequest.getEmail());
                user.setUserPassword(actualRequest.getPassword());
                user.setUserRole(actualRequest.getUserType());
            }
        }
        request.ifPresent(value -> value.setStatus(status));
        requestRepository.save(request.get());


        return request;
    }
}
