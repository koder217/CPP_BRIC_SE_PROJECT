package edu.cpp.brcm.repositories;

import edu.cpp.brcm.entities.Activity;
import edu.cpp.brcm.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ActivityRepository  extends JpaRepository<Activity, Integer> {

}
