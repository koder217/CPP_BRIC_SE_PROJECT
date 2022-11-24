package edu.cpp.brcm.repositories;

import edu.cpp.brcm.entities.Order;

import java.util.Date;
import java.util.List;

public interface OrderRepository {
    void saveOrder(Order order);
    void updateOrder(Order order);
    List<Order> getOrdersBetweenDates(Date start, Date end);
}
