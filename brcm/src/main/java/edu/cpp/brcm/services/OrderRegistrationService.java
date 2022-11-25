package edu.cpp.brcm.services;

import edu.cpp.brcm.dtos.AppointmentDto;
import edu.cpp.brcm.dtos.LineitemDto;
import edu.cpp.brcm.dtos.OrderDto;
import edu.cpp.brcm.dtos.VisitDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderRegistrationService {
    Integer createNewOrder(VisitDto visitDto);
    List<OrderDto> getAllOrders();
    List<OrderDto> getAllOrdersForCustomer(int id);
    void deleteLineItem(int orderid, int lineItemId);
    void addLineItem(int orderid, LineitemDto lineitem);
    void deleteOrder(int id);
}
