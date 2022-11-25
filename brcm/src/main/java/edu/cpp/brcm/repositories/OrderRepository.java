package edu.cpp.brcm.repositories;

import edu.cpp.brcm.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    public List<Order> findAllByCustomerid(int id);
}
