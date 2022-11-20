package services;

import dtos.ProfessorDto;
import dtos.StudentDto;
import java.util.List;

public interface CustomerManagementService {
    void saveStudent(StudentDto student);
    void saveProfessor(ProfessorDto professor);
    StudentDto getStudentByBroncoId(int id);
    ProfessorDto getProfessorByBroncoId(int id);
    void updateStudent(StudentDto student);
    void updateProfessor(ProfessorDto professor);
    void deleteStudentByBroncoId(int id);
    void deleteProfessorByBroncoId(int id);
    List<StudentDto> listStudentsbyMajor(String major);
    List<ProfessorDto> listProfessorsbyDept(String dept);
}
