package impl;

import dtos.ProfessorDto;
import dtos.StudentDto;
import entities.Customer;
import entities.Student;
import repositories.CustomerRepository;
import repositories.ProfessorRepository;
import repositories.StudentRepository;
import services.CustomerManagementService;

import java.util.List;

public class CustomerManagementServiceImpl implements CustomerManagementService {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final CustomerRepository customerRepository;
    public CustomerManagementServiceImpl(StudentRepository studentRepository, ProfessorRepository professorRepository, CustomerRepository customerRepository){
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveStudent(StudentDto student) {
        Customer c = new Customer();
        c.setDateofbirth(student.getDateofbirth());
        c.setFirstname(student.getFirstname());
        c.setLastname(student.getLastname());
        c.setPhone(student.getPhone());
        Student s = new Student();
        s.setCustomer(c);
        s.setEnterdate(student.getGraddate());
        s.setEnterdate(student.getEnterdate());
        s.setMajor(student.getMajor());
        s.setMinor(student.getMinor());
        studentRepository.saveStudent(s);
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
