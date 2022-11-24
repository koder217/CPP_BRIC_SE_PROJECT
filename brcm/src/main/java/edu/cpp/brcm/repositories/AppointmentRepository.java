package edu.cpp.brcm.repositories;

import edu.cpp.brcm.entities.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository {
    Appointment saveAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    void updateAppointmentStatus(int id, String status);
    List<Appointment> getAllAppointmentsBetweenDates(LocalDate startDate, LocalDate endDate);
}
