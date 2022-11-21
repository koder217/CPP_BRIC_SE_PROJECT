package impl;

import common.Hibernate;
import entities.Customer;
import org.hibernate.Session;
import repositories.CustomerRepository;

import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Session session;

    public CustomerRepositoryImpl(){
        session = Hibernate.getSession();
    }
    @Override
    public Customer getCustomerById(int id) {
        Customer customer = (Customer)session.get(Customer.class, id);
        return customer;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        int id = (Integer)session.save(customer);
        session.flush();
        customer.setId(id);
        return customer;
    }

    @Override
    public <S extends Customer> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Customer> findAll() {
        return null;
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Customer entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
