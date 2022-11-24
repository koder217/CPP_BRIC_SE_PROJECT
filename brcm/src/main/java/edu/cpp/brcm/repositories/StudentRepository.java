package edu.cpp.brcm.repositories;

import edu.cpp.brcm.entities.Customer;
import edu.cpp.brcm.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
//    Student saveStudent(Student student);
//    void deleteStudent(int id);
//    void updateStudent(Student student);
//    Student getStudentById(int id);
//    List<Student> getStudentsByMajor(String major);
}
