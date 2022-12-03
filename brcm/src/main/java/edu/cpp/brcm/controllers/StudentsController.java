package edu.cpp.brcm.controllers;

import edu.cpp.brcm.dtos.StudentDto;
import edu.cpp.brcm.services.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class StudentsController {
    @Autowired
    private CustomerManagementService customerManagementService;
    @GetMapping("/students")
    public List<StudentDto> getAllStudents() {
        return customerManagementService.listStudentsbyMajor("");
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> postStudents(@Valid @RequestBody StudentDto studentDto){
        StudentDto resp = customerManagementService.saveStudent(studentDto);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity.BodyBuilder deleteStudents(@PathVariable(value = "id") int studentId){
        customerManagementService.deleteStudentByBroncoId(studentId);
        return ResponseEntity.ok();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(value = "id") int studentId)
            throws Exception {
        StudentDto student = customerManagementService.getStudentByBroncoId(studentId);
        return ResponseEntity.ok().body(student);
    }
}
