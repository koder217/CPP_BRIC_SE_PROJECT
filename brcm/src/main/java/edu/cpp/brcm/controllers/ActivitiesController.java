package edu.cpp.brcm.controllers;

import edu.cpp.brcm.dtos.ActivityDto;
import edu.cpp.brcm.dtos.StudentDto;
import edu.cpp.brcm.services.ActivityRegistrationService;
import edu.cpp.brcm.services.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActivitiesController {
    @Autowired
    private ActivityRegistrationService activityRegistrationService;
    @GetMapping("/activities")
    public List<ActivityDto> getAllStudents() {
        return activityRegistrationService.getAllActivities();
    }
}
