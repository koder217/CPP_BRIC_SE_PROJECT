package edu.cpp.brcm.repositories;

import edu.cpp.brcm.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository  extends JpaRepository<Activity, Integer> {

}
