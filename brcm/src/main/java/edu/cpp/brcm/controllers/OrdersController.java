package edu.cpp.brcm.controllers;

import edu.cpp.brcm.dtos.OrderDto;
import edu.cpp.brcm.dtos.StudentDto;
import edu.cpp.brcm.dtos.VisitDto;
import edu.cpp.brcm.services.OrderRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class OrdersController {
    @Autowired
    private OrderRegistrationService orderRegistrationService;

    @PostMapping("/orders")
    public Map<String,String> postOrder(@RequestBody VisitDto visitDto){
        int id = orderRegistrationService.createNewOrder(visitDto);
        Map<String, String> response = new HashMap<>();
        response.put("order", Integer.toString(id));
        return response;
    }
}
