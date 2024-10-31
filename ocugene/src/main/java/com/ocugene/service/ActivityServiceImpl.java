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

        Activity activity = new Activity();
        return activityRepository.save(addActivityRequest.mapToActivity(activity));
    }

    @Override
    public Activity deleteActivityByID(Integer activityID) {

        Activity deletedActivity = activityRepository.findById(activityID).get();
        activityRepository.deleteById(activityID);

        return deletedActivity;
    }

    @Override
    public Activity editActivity(Integer activityID, AddActivityRequest editActivityRequest) {

        Activity activityToBeEdited = activityRepository.findById(activityID).get();
        return activityRepository.save(editActivityRequest.mapToActivity(activityToBeEdited));
    }
}
