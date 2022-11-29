package edu.cpp.brcm.impl;

import edu.cpp.brcm.common.Mapper;
import edu.cpp.brcm.dtos.AddressDto;
import edu.cpp.brcm.dtos.ProfessorDto;
import edu.cpp.brcm.dtos.StudentDto;
import edu.cpp.brcm.entities.Address;
import edu.cpp.brcm.entities.Customer;
import edu.cpp.brcm.entities.Professor;
import edu.cpp.brcm.entities.Student;
import edu.cpp.brcm.repositories.AddressRepository;
import edu.cpp.brcm.repositories.ProfessorRepository;
import edu.cpp.brcm.repositories.StudentRepository;
import edu.cpp.brcm.services.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManagementServiceImpl implements CustomerManagementService {

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public StudentDto saveStudent(StudentDto student) {
        Student s = Mapper.toEntity(student);
        Address a = addressRepository.save(s.getCustomers().getAddressid());
        s.getCustomers().setAddressid(a);
        Student resp = studentRepository.save(s);
        return Mapper.toDTO(resp);
    }

    @Override
    public ProfessorDto saveProfessor(ProfessorDto professor) {
        Professor p = Mapper.toEntity(professor);
        Address a = addressRepository.save(p.getCustomers().getAddressid());
        p.getCustomers().setAddressid(a);
        Professor resp = professorRepository.save(p);
        return Mapper.toDTO(resp);
    }

    @Override
    public StudentDto getStudentByBroncoId(int id) {
        return Mapper.toDTO(studentRepository.findById(id).get());
    }

    @Override
    public ProfessorDto getProfessorByBroncoId(int id) {
        return Mapper.toDTO(professorRepository.findById(id).get());
    }

    @Override
    public void updateStudent(StudentDto student) {
        Student s = studentRepository.findById(student.getId()).orElseThrow(()->new ResourceAccessException("Student not found with id:"+student.getId()));
        Customer c = s.getCustomers();
        c.setDateofbirth(student.getDateofbirth());
        c.setFirstname(student.getFirstname());
        c.setLastname(student.getLastname());
        c.setPhone(student.getPhone());
        AddressDto a = student.getAddress();
        if (a != null){
            c.getAddressid().setStreet(a.getStreet());
            c.getAddressid().setState(a.getState());
            c.getAddressid().setZipcode(a.getZipcode());
            c.getAddressid().setNumber(a.getNumber());
            c.getAddressid().setCity(a.getCity());
            c.setAddressid(addressRepository.save(Mapper.toEntity(a)));
        }
        s.setCustomers(c);
        s.setGraddate(student.getGraddate());
        s.setEnterdate(student.getEnterdate());
        s.setMajor(student.getMajor());
        s.setMinor(student.getMinor());
        studentRepository.save(s);
    }

    @Override
    public void updateProfessor(ProfessorDto professor) {
        Professor p = professorRepository.findById(professor.getId()).orElseThrow(()->new ResourceAccessException("Professor not found with id:"+professor.getId()));
        Customer c = p.getCustomers();
        c.setDateofbirth(professor.getDateofbirth());
        c.setFirstname(professor.getFirstname());
        c.setLastname(professor.getLastname());
        c.setPhone(professor.getPhone());
        AddressDto a = professor.getAddress();
        if (a != null){
            c.getAddressid().setStreet(a.getStreet());
            c.getAddressid().setState(a.getState());
            c.getAddressid().setZipcode(a.getZipcode());
            c.getAddressid().setNumber(a.getNumber());
            c.getAddressid().setCity(a.getCity());
            c.setAddressid(addressRepository.save(Mapper.toEntity(a)));
        }
        p.setCustomers(c);
        p.setResearch(professor.getResearch());
        p.setOffice(professor.getOffice());
        p.setDepartment(professor.getDepartment());
        professorRepository.save(p);
    }

    @Override
    public void deleteStudentByBroncoId(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteProfessorByBroncoId(int id) {
        professorRepository.deleteById(id);
    }

    @Override
    public List<StudentDto> listStudentsbyMajor(String major) {
        List<StudentDto> students = studentRepository
                .findAll()
                .stream()
                .map(s->Mapper.toDTO((Student) s))
                .collect(Collectors.toList());
        return students;
    }

    @Override
    public List<ProfessorDto> listProfessorsbyDept(String dept) {
        List<ProfessorDto> professors = professorRepository
                .findAll()
                .stream()
                .map(p->Mapper.toDTO((Professor) p))
                .collect(Collectors.toList());
        return professors;
    }
}
