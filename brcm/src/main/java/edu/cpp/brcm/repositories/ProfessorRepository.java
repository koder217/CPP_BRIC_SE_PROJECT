package edu.cpp.brcm.repositories;

import edu.cpp.brcm.entities.Customer;
import edu.cpp.brcm.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
//    Professor saveProfessor(Professor Professor);
//    void deleteProfessor(int id);
//    void updateProfessor(int id);
//    void getProfessorById(int id);
//    List<Professor> getProfessorsByDept(String dept);
}
