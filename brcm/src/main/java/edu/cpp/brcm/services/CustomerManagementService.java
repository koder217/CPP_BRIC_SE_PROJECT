package edu.cpp.brcm.services;

import edu.cpp.brcm.dtos.ProfessorDto;
import edu.cpp.brcm.dtos.StudentDto;
import java.util.List;


public interface CustomerManagementService {
    int saveStudent(StudentDto student);
    Integer saveProfessor(ProfessorDto professor);
    StudentDto getStudentByBroncoId(int id);
    ProfessorDto getProfessorByBroncoId(int id);
    void updateStudent(StudentDto student);
    void updateProfessor(ProfessorDto professor);
    void deleteStudentByBroncoId(int id);
    void deleteProfessorByBroncoId(int id);
    List<StudentDto> listStudentsbyMajor(String major);
    List<ProfessorDto> listProfessorsbyDept(String dept);
}
