package edu.cpp.brcm.controllers;

import edu.cpp.brcm.dtos.OrderDto;
import edu.cpp.brcm.dtos.StudentDto;
import edu.cpp.brcm.dtos.VisitDto;
import edu.cpp.brcm.services.OrderRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<OrderDto> postOrder(@RequestBody VisitDto visitDto){
        var order = orderRegistrationService.createNewOrder(visitDto);
        return ResponseEntity.ok(order);
    }
}
