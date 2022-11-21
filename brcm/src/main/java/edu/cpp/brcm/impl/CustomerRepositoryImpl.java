//package edu.cpp.brcm.impl;
//
//import common.Hibernate;
//import edu.cpp.brcm.entities.Customer;
//import org.hibernate.Session;
//import edu.cpp.brcm.repositories.CustomerRepository;
//
//import java.util.Optional;
//
//public class CustomerRepositoryImpl implements CustomerRepository {
//    private Session session;
//
//    public CustomerRepositoryImpl(){
//        session = Hibernate.getSession();
//    }
//    @Override
//    public Customer getCustomerById(int id) {
//        Customer customer = (Customer)session.get(Customer.class, id);
//        return customer;
//    }
//
//    @Override
//    public Customer saveCustomer(Customer customer) {
//        int id = (Integer)session.save(customer);
//        session.flush();
//        customer.setId(id);
//        return customer;
//    }
//}
