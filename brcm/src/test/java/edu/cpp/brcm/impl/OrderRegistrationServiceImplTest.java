package edu.cpp.brcm.impl;

import edu.cpp.brcm.dtos.AppointmentDto;
import edu.cpp.brcm.dtos.LineitemDto;
import edu.cpp.brcm.dtos.VisitDto;
import edu.cpp.brcm.entities.*;
import edu.cpp.brcm.enums.CustomerType;
import edu.cpp.brcm.repositories.*;
import edu.cpp.brcm.services.OrderRegistrationService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderRegistrationServiceImplTest {
    @Mock
    private AppointmentRepository appointmentRepository;
    @Mock
    private DiscountSchemeRepository discountSchemeRepository;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private ProfessorRepository professorRepository;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ActivityRepository activityRepository;
    @Mock
    private LineItemRepository lineItemRepository;
    private OrderRegistrationService orderRegistrationService;

    @BeforeEach
    void setUp()
    {
        this.orderRegistrationService = new OrderRegistrationServiceImpl(appointmentRepository, discountSchemeRepository, studentRepository, professorRepository, orderRepository,activityRepository, lineItemRepository);
    }

    @Test
    void createNewOrder_PassNull_ReturnsNull(){
        var result = this.orderRegistrationService.createNewOrder(null);
        Assert.assertNull(result);
    }

    @Test
    void createNewOrder_PassNoLineItems_ReturnsNull(){
        VisitDto v = new VisitDto();
        var result = this.orderRegistrationService.createNewOrder(v);
        Assert.assertNull(result);
    }

    @Test
    void createNewOrder_CustomerType_Student_Calls_StudentRepository_findById(){
        //mock
        var c=new Customer();
        var m = Mockito.mock(Student.class);
        Mockito.when(m.getCustomers()).thenReturn(c);
        m.setCustomers(c);
        Mockito.when(studentRepository.findById(1)).thenReturn(Optional.ofNullable(m));
        var ma = Mockito.mock(Activity.class);
        var ml = Mockito.mock(Lineitem.class);
        var mo = Mockito.mock(Order.class);
        Mockito.when(activityRepository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.ofNullable(ma));
        Mockito.when(ml.getActivityid()).thenReturn(ma);
        Mockito.when(ml.getOrderid()).thenReturn(mo);
        Mockito.when(lineItemRepository.save(ArgumentMatchers.any(Lineitem.class))).thenReturn(ml);
        Mockito.when(orderRepository.save(ArgumentMatchers.any(Order.class))).thenReturn(mo);
        //call
        VisitDto v = new VisitDto();
        v.customerId = 1;
        v.customerType = CustomerType.STUDENT;
        v.lineItems = new ArrayList<>();
        v.lineItems.add(new LineitemDto(1, 1, new AppointmentDto(1, Instant.now(), Instant.now(), 1, 1, "status"), 1, 1));
        var result = this.orderRegistrationService.createNewOrder(v);
        //verify
        verify(studentRepository).findById(1);
    }

    @Test
    void createNewOrder_CustomerType_Professor_Calls_ProfessorRepository_findById(){
        //mock
        var c=new Customer();
        var m = Mockito.mock(Professor.class);
        Mockito.when(m.getCustomers()).thenReturn(c);
        m.setCustomers(c);
        Mockito.when(professorRepository.findById(1)).thenReturn(Optional.ofNullable(m));
        var ma = Mockito.mock(Activity.class);
        var ml = Mockito.mock(Lineitem.class);
        var mo = Mockito.mock(Order.class);
        Mockito.when(activityRepository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.ofNullable(ma));
        Mockito.when(ml.getActivityid()).thenReturn(ma);
        Mockito.when(ml.getOrderid()).thenReturn(mo);
        Mockito.when(lineItemRepository.save(ArgumentMatchers.any(Lineitem.class))).thenReturn(ml);
        Mockito.when(orderRepository.save(ArgumentMatchers.any(Order.class))).thenReturn(mo);
        //call
        VisitDto v = new VisitDto();
        v.customerId = 1;
        v.customerType = CustomerType.PROFESSOR;
        v.lineItems = new ArrayList<>();
        v.lineItems.add(new LineitemDto(1, 1, new AppointmentDto(1, Instant.now(), Instant.now(), 1, 1, "status"), 1, 1));
        var result = this.orderRegistrationService.createNewOrder(v);
        //verify
        verify(professorRepository).findById(1);
    }
}
