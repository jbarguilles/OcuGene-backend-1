package com.ocugene.controller;

import com.ocugene.entity.Activity;
import com.ocugene.entity.requests.AddActivityRequest;
import com.ocugene.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = {"/activity"})
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Activity>> getAllActivities() {
        return ResponseEntity.ok(activityService.getAllActivities());
    }

    @PostMapping("/add")
    public ResponseEntity<Activity> addActivity(@RequestBody AddActivityRequest addActivityRequest) {
        return ResponseEntity.ok(activityService.addActivity(addActivityRequest));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Activity> deleteActivity(@RequestParam Integer activityID) {
        return ResponseEntity.ok(activityService.deleteActivityByID(activityID));
    }

    @PutMapping("/edit")
    public ResponseEntity<Activity> editActivity(@RequestParam Integer activityID, @RequestBody AddActivityRequest editActivityRequest) {
        return ResponseEntity.ok(activityService.editActivity(activityID, editActivityRequest));
    }

}
