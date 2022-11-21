package repositories;

import entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer getCustomerById(int id);
    Customer saveCustomer(Customer customer);
}
