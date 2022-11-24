package edu.cpp.brcm.controllers;

import edu.cpp.brcm.dtos.StudentDto;
import edu.cpp.brcm.services.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    private CustomerManagementService customerManagementService;
    @GetMapping("/students")
    public List<StudentDto> getAllStudents() {
        return customerManagementService.listStudentsbyMajor("");
    }

    @PostMapping("/students")
    public Map<String,String> postStudents(@RequestBody StudentDto studentDto){
        int id = customerManagementService.saveStudent(studentDto);
        Map<String, String> response = new HashMap<>();
        response.put("student", Integer.toString(id));
        return response;
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity.BodyBuilder deleteStudents(@PathVariable(value = "id") int studentId){
        customerManagementService.deleteStudentByBroncoId(studentId);
        return ResponseEntity.ok();
    }

//    @GetMapping("/customers/{id}")
//    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") int CustomerId)
//            throws Exception {
//        Customer Customer = repository.findById(CustomerId)
//                .orElseThrow(() -> new Exception("Customer not found for this id :: " + CustomerId));
//        return ResponseEntity.ok().body(Customer);
//    }
}
