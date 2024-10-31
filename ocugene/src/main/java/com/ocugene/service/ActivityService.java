package com.ocugene.service;

import com.ocugene.entity.Activity;
import com.ocugene.entity.requests.AddActivityRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {

    List<Activity> getAllActivities();

    Activity addActivity(AddActivityRequest addActivityRequest);
}
