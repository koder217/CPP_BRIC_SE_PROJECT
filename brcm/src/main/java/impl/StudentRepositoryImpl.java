package impl;

import common.Hibernate;
import entities.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repositories.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StudentRepositoryImpl implements StudentRepository {
    private Session session;

    public StudentRepositoryImpl(){
        session = Hibernate.getSession();
    }

    @Override
    public Student saveStudent(Student student) {
        int id = (Integer)session.save(student);
        session.flush();
        student.setId(id);
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        Student student = (Student)session.get(Student.class, id);
        session.delete(student);
    }

    @Override
    public void updateStudent(Student student) {
        saveStudent(student);
    }

    @Override
    public Student getStudentById(int id) {
        Student student = (Student)session.get(Student.class, id);
        return student;
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        String hql = "FROM Student s WHERE s.major = :major";
        Query q = session.createQuery(hql);
        q.setParameter("major", major);
        List results = q.list();
        List<Student> ss = (List<Student>) results.stream().map(o -> (Student)o).collect(Collectors.toList());
        return ss;
    }
}
