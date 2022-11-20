package impl;

import dtos.ProfessorDto;
import dtos.StudentDto;
import repositories.ProfessorRepository;
import repositories.StudentRepository;
import services.CustomerManagementService;

import java.util.List;

public class CustomerManagementServiceImpl implements CustomerManagementService {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;

    public CustomerManagementServiceImpl(StudentRepository studentRepository, ProfessorRepository professorRepository){
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public void saveStudent(StudentDto student) {

    }

    @Override
    public void saveProfessor(ProfessorDto professor) {

    }

    @Override
    public StudentDto getStudentByBroncoId(int id) {
        return null;
    }

    @Override
    public ProfessorDto getProfessorByBroncoId(int id) {
        return null;
    }

    @Override
    public void updateStudent(StudentDto student) {

    }

    @Override
    public void updateProfessor(ProfessorDto professor) {

    }

    @Override
    public void deleteStudentByBroncoId(int id) {

    }

    @Override
    public void deleteProfessorByBroncoId(int id) {

    }

    @Override
    public List<StudentDto> listStudentsbyMajor(String major) {
        return null;
    }

    @Override
    public List<ProfessorDto> listProfessorsbyDept(String dept) {
        return null;
    }
}
