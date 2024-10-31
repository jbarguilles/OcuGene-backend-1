package com.ocugene.service;

import com.ocugene.entity.Activity;
import com.ocugene.entity.requests.AddActivityRequest;
import com.ocugene.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService{

    @Autowired
    ActivityRepository activityRepository;

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public Activity addActivity(AddActivityRequest addActivityRequest) {
        return activityRepository.save(addActivityRequest.mapToActivity());
    }
}
