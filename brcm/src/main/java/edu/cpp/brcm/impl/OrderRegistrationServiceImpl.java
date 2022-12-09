package edu.cpp.brcm.impl;

import edu.cpp.brcm.common.Mapper;
import edu.cpp.brcm.dtos.*;
import edu.cpp.brcm.entities.*;
import edu.cpp.brcm.enums.CustomerType;
import edu.cpp.brcm.repositories.*;
import edu.cpp.brcm.services.OrderRegistrationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class OrderRegistrationServiceImpl implements OrderRegistrationService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DiscountSchemeRepository discountSchemeRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private LineItemRepository lineItemRepository;

//    public AppointmentDto createNewAppointment(AppointmentDto appointmentDto) {
//        Appointment a = Mapper.toEntity(appointmentDto);
//        a = appointmentRepository.save(a);
//        return Mapper.toDTO(a);
//    }
//
//    public List<AppointmentDto> getAllAppointments() {
//        return appointmentRepository.findAll().stream().map(Mapper::toDTO).collect(Collectors.toList());
//    }
//
//    public void updateAppointment(AppointmentDto appointmentDto) {
//        Appointment a = appointmentRepository.findById(appointmentDto.getId()).orElseThrow(() -> new ResourceAccessException("Appointment not found for id:" + appointmentDto.getId()));
//        a.setStatus(appointmentDto.getStatus());
//        a.setStarttime(appointmentDto.getStarttime());
//        a.setEndtime(appointmentDto.getEndtime());
//        a.setActivityid(appointmentDto.getActivityid());
//        a.setCustomerid(appointmentDto.getCustomerid());
//        appointmentRepository.save(a);
//    }
//
//    public void deleteAppointment(int id) {
//        appointmentRepository.deleteById(id);
//    }

    @Override
    public OrderDto createNewOrder(VisitDto visitDto) {
        if (visitDto == null || visitDto.lineItems == null || visitDto.lineItems.size() == 0)
            return null;
        Customer customer = null;
        if (visitDto.customerType == CustomerType.STUDENT) {
            var student = studentRepository.findById(visitDto.customerId).get();
            customer = student.getCustomers();
        } else if (visitDto.customerType == CustomerType.PROFESSOR) {
            var professor = professorRepository.findById(visitDto.customerId).get();
            customer = professor.getCustomers();
        }
        //create order first, appointments next, then line items.
        Order o = new Order();
        o.setCustomerType(visitDto.customerType.toString());
        o.setDate(LocalDate.now());
        o.setTime(LocalTime.now());
        o.setCustomerid(customer);
        o.setDiscountapplied(0.0); //update after order is generated.
        o.setTotalprice(0.0); //update after order is generated.
        var schemes = discountSchemeRepository.findAll();
        Discountscheme effectiveDiscountScheme = null;
        for (Discountscheme s : schemes) {
            //TODO: also do a date check
            if (Objects.equals(s.getCustomertype(), o.getCustomerType())) {
                o.setDiscountschemeid(s);
                effectiveDiscountScheme = s;
            }
        }
        o = orderRepository.save(o);
        List<LineitemDto> lineItems = visitDto.lineItems;
        List<Lineitem> lineItemsEntities = new ArrayList<>();
        double totalPriceBeforeDiscount = 0.0;
        for (LineitemDto lineitemDto : lineItems) {
            //create appointment
            AppointmentDto appt = lineitemDto.getAppointment();
            Appointment a = Mapper.toEntity(appt);
            assert customer != null;
            a.setCustomerid(customer.getId());
            a.setStatus("online-pending");
            a = appointmentRepository.save(a);

            //create lineitem
            Lineitem lt = new Lineitem();
            Activity act = activityRepository.findById(appt.getActivityid()).get();
            lt.setActivityid(act);
            lt.setQuantity(lineitemDto.getQuantity());
            lt.setAppointmentid(a);
            lt.setOrderid(o);
            lt = lineItemRepository.save(lt);
            lineItemsEntities.add(lt);
            totalPriceBeforeDiscount += act.getPrice() * lt.getQuantity();
        }

        //calculate discount
        var effectiveTotalPriceAfterDiscount = 0.0;
        if (effectiveDiscountScheme != null) {
            var percentDiscount = effectiveDiscountScheme.getPercentdiscount();
            var priceDiscount = effectiveDiscountScheme.getPricediscount();
            var percentDiscounted = (percentDiscount / 100) * totalPriceBeforeDiscount;
            var totalPriceAfterPercentDiscount = totalPriceBeforeDiscount - percentDiscounted;
            var totalPriceAfterPriceDiscount = totalPriceBeforeDiscount - priceDiscount;
            if (totalPriceAfterPriceDiscount < 0) { //price ended up being -ve.
                effectiveTotalPriceAfterDiscount = 0; //FREE!
                o.setDiscountapplied(priceDiscount);
            } else {
                if (totalPriceAfterPercentDiscount > totalPriceAfterPriceDiscount) {
                    o.setDiscountapplied(priceDiscount);
                    effectiveTotalPriceAfterDiscount = totalPriceAfterPriceDiscount;
                } else {
                    o.setDiscountapplied(percentDiscounted);
                    effectiveTotalPriceAfterDiscount = totalPriceAfterPercentDiscount;
                }
            }
        }
        o.setTotalprice(effectiveTotalPriceAfterDiscount);
        o = orderRepository.save(o);
        return Mapper.toDTO(o, lineItemsEntities);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(o -> Mapper.toDTO(o, null)).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getAllOrdersForCustomer(int id) {
        var orderList = orderRepository.findAllByCustomerid(id).stream().toList();
        List<OrderDto> result = new ArrayList<>();
        if (orderList.size() > 0) {
            for (Order o : orderList) {
                List<Lineitem> lineitems = lineItemRepository.findAllByOrderid(o.getId());
                var dto = Mapper.toDTO(o, lineitems);
                result.add(dto);
            }
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void deleteLineItem(int orderid, int lineItemId) {
        lineItemRepository.deleteById(lineItemId);
    }

    @Override
    public void addLineItem(int orderid, LineitemDto lineitem) {
        var order = orderRepository.findById(orderid).get();
        Lineitem lt = new Lineitem();
        lt.setOrderid(order);
        lt.setQuantity(lineitem.getQuantity());
        Appointment appt = Mapper.toEntity(lineitem.getAppointment());
        lt.setAppointmentid(appt);
        Activity act = activityRepository.findById(lineitem.getActivityid()).get();
        lt.setActivityid(act);
        lineItemRepository.save(lt);
    }

    @Override
    public void deleteOrder(int id) {
        //delete appointments and lineitems first.
        var lineItems = lineItemRepository.findAllByOrderid(id);
        for (Lineitem lt : lineItems) {
            appointmentRepository.delete(lt.getAppointmentid());
            lineItemRepository.delete(lt);
        }
        orderRepository.deleteById(id);
    }
}
