package edu.cpp.brcm.services;

import edu.cpp.brcm.dtos.ActivityDto;

import java.util.List;

public interface ActivityRegistrationService {
    List<ActivityDto> getAllActivities();
    ActivityDto saveNewActivity(ActivityDto activityDto);
    void deleteActivity(Integer id);
    void updateActivity(ActivityDto activityDto);
}
