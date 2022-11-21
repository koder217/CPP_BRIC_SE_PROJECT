package edu.cpp.brcm;

import edu.cpp.brcm.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    Customer getCustomerById(int id);
//    Customer saveCustomer(Customer customer);
}
