package edu.cpp.brcm.repositories;

import edu.cpp.brcm.entities.Lineitem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineItemRepository extends JpaRepository<Lineitem, Integer> {
    public List<Lineitem> findAllByOrderid(int id);
}
