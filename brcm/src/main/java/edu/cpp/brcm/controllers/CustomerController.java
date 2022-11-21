package edu.cpp.brcm.controllers;

import edu.cpp.brcm.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.cpp.brcm.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") int CustomerId)
            throws Exception {
        Customer Customer = repository.findById(CustomerId)
                .orElseThrow(() -> new Exception("Customer not found for this id :: " + CustomerId));
        return ResponseEntity.ok().body(Customer);
    }
}
