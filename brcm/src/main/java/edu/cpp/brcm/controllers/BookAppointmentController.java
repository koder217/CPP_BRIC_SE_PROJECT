package edu.cpp.brcm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookAppointmentController {
    @RequestMapping("/")
    public String welcome() {
        return "index";
    }
}
