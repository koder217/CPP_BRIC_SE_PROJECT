package edu.cpp.brcm.repositories;

import edu.cpp.brcm.entities.Historicalprice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceHistoryRepository extends JpaRepository<Historicalprice, Integer>{
    public List<Historicalprice> findByActivityid(int id);
}
