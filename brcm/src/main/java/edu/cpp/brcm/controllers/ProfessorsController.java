package edu.cpp.brcm.controllers;

import edu.cpp.brcm.dtos.ProfessorDto;
import edu.cpp.brcm.dtos.StudentDto;
import edu.cpp.brcm.services.CustomerManagementService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "Professors", description = "CRUD for Professors")
@RequestMapping("/api/v1")
public class ProfessorsController {
    @Autowired
    private CustomerManagementService customerManagementService;
    @GetMapping("/professors")
    public List<ProfessorDto> getAllProfessors() {
        return customerManagementService.listProfessorsbyDept("");
    }

    @PostMapping("/professors")
    public ResponseEntity<ProfessorDto> postProfessors(@RequestBody ProfessorDto professorDto){
        var profDto = customerManagementService.saveProfessor(professorDto);
        return ResponseEntity.ok().body(profDto);
    }
    @PutMapping("/professors/{id}")
    public ResponseEntity.BodyBuilder putProfessors(@PathVariable(value = "id") int professorId, @Valid @RequestBody ProfessorDto professorDto){
        customerManagementService.updateProfessor(professorDto);
        return ResponseEntity.ok();
    }
    @DeleteMapping("/professors/{id}")
    public ResponseEntity.BodyBuilder deleteprofessors(@PathVariable(value = "id") int professorId){
        customerManagementService.deleteProfessorByBroncoId(professorId);
        return ResponseEntity.ok();
    }

    @GetMapping("/professors/{id}")
    public ResponseEntity<ProfessorDto> getProfessorById(@PathVariable(value = "id") int professorId)
            throws Exception {
        ProfessorDto professor = customerManagementService.getProfessorByBroncoId(professorId);
        return ResponseEntity.ok().body(professor);
    }
}
