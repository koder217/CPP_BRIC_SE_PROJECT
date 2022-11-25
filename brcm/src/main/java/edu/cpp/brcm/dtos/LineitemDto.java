package edu.cpp.brcm.dtos;

import edu.cpp.brcm.entities.Lineitem;

import java.io.Serializable;

/**
 * A DTO for the {@link Lineitem} entity
 */
public class LineitemDto implements Serializable {
    private final Integer id;
    private final Integer activityid;
    private final AppointmentDto appointment;
    private final Integer quantity;
    private final Integer orderid;

    public LineitemDto(Integer id, Integer activityId, AppointmentDto appointment, Integer quantity, Integer orderid) {
        this.id = id;
        this.activityid = activityId;
        this.appointment = appointment;
        this.quantity = quantity;
        this.orderid = orderid;
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public AppointmentDto getAppointment() {
        return appointment;
    }

    public Integer getOrderid() {
        return orderid;
    }
}