package edu.cpp.brcm.repositories;

import edu.cpp.brcm.entities.Activity;

import java.util.List;

public interface ActivityRepository {
    Activity saveActivity(Activity activity);
    List<Activity> getAllActivities();
    void updateActivity(Activity activity);
    void deleteActivity(int id);
}
