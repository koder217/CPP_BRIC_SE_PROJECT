package edu.cpp.brcm.repositories;

import edu.cpp.brcm.entities.Discountscheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountSchemeRepository extends JpaRepository<Discountscheme, Integer> {
}
