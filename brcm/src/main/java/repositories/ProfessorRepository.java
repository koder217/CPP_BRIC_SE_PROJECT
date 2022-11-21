package repositories;

import entities.Professor;
import java.util.List;
public interface ProfessorRepository {
    Professor saveProfessor(Professor Professor);
    void deleteProfessor(int id);
    void updateProfessor(int id);
    void getProfessorById(int id);
    List<Professor> getProfessorsByDept(String dept);
}
