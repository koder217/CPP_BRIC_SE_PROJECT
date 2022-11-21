package edu.cpp.brcm;

import edu.cpp.brcm.entities.Student;
import java.util.List;

public interface StudentRepository {
    Student saveStudent(Student student);
    void deleteStudent(int id);
    void updateStudent(Student student);
    Student getStudentById(int id);
    List<Student> getStudentsByMajor(String major);
}
