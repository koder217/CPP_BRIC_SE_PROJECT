package repositories;

import entities.Student;
import java.util.List;

public interface StudentRepository {
    Student saveStudent(Student student);
    void deleteStudent(int id);
    void updateStudent(int id);
    void getStudentById(int id);
    List<Student> getStudentsByMajor(String major);
}
