package com.ocugene.entity.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ocugene.entity.Activity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class AddActivityRequest {

    @JsonProperty("title")
    private String title;

    @JsonProperty("type")
    private String activityType;

    @JsonProperty("date")
    private String date;

    @JsonProperty("start_time")
    private String startTime;

    @JsonProperty("end_time")
    private String endTime;

    @JsonProperty("location")
    private String location;

    public Activity mapToActivity(){

        Activity activity = new Activity();

        activity.setTitle(this.title);
        activity.setActivityType(this.activityType);
        activity.setDate(Date.valueOf(this.date));
        activity.setLocation(this.location);

        // Define the formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Parse the time strings into LocalTime
        LocalTime startLocalTime = LocalTime.parse(this.startTime, formatter);
        LocalTime endLocalTime = LocalTime.parse(this.endTime, formatter);

        // Convert LocalTime to java.sql.Time
        Time startTime = Time.valueOf(startLocalTime);
        Time endTime = Time.valueOf(endLocalTime);

        activity.setStartTime(startTime);
        activity.setEndTime(endTime);

        return activity;
    }

}
