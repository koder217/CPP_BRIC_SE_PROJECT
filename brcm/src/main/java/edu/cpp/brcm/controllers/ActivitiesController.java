package edu.cpp.brcm.controllers;

import edu.cpp.brcm.dtos.ActivityDto;
import edu.cpp.brcm.dtos.StudentDto;
import edu.cpp.brcm.services.ActivityRegistrationService;
import edu.cpp.brcm.services.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActivitiesController {
    @Autowired
    private ActivityRegistrationService activityRegistrationService;
    @GetMapping("/activities")
    public List<ActivityDto> getAllActivties() {
        return activityRegistrationService.getAllActivities();
    }
    @PutMapping("/activities/{id}")
    public void putActivity(@PathVariable(value = "id") int id,@RequestBody ActivityDto activityDto){
        activityRegistrationService.updateActivity(activityDto);
    }
    @DeleteMapping("/activities/{id}")
    public void deleteActivity(@PathVariable(value = "id") int id){
        activityRegistrationService.deleteActivity(id);
    }

    @PostMapping("/activities")
    public ActivityDto postActivity(@RequestBody ActivityDto activityDto){
        return activityRegistrationService.saveNewActivity(activityDto);
    }
}
