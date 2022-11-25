package edu.cpp.brcm.common;

import edu.cpp.brcm.dtos.*;
import edu.cpp.brcm.entities.*;

import java.util.List;

public class Mapper {
    public static Address toEntity(AddressDto addressDto){
        if(addressDto == null){
            return null;
        }
        Address a = new Address();
        a.setStreet(addressDto.getStreet());
        a.setCity(addressDto.getCity());
        a.setNumber(addressDto.getNumber());
        a.setState(addressDto.getState());
        a.setZipcode(addressDto.getZipcode());
        return a;
    }
    public static AddressDto toDTO(Address address){
        if(address == null){
            return null;
        }
        AddressDto addressDto = new AddressDto(address.getId(),
                address.getStreet(),
                address.getNumber(),
                address.getZipcode(),
                address.getCity(),
                address.getState());
        return addressDto;
    }

    public static Student toEntity(StudentDto student){
        if(student == null){
            return null;
        }
        Customer c = new Customer();
        c.setDateofbirth(student.getDateofbirth());
        c.setFirstname(student.getFirstname());
        c.setLastname(student.getLastname());
        c.setPhone(student.getPhone());
        c.setAddressid(Mapper.toEntity(student.getAddress()));
        Student s = new Student();
        s.setCustomers(c);
        s.setGraddate(student.getGraddate());
        s.setEnterdate(student.getEnterdate());
        s.setMajor(student.getMajor());
        s.setMinor(student.getMinor());
        return s;
    }

    public static StudentDto toDTO(Student s){
        if(s == null){
            return null;
        }
        AddressDto addressDto = Mapper.toDTO(s.getCustomers().getAddressid());
        return new StudentDto(s.getId(),
                s.getEnterdate(),
                s.getMajor(),
                s.getMinor(),
                s.getGraddate(),
                s.getCustomers().getFirstname(),
                s.getCustomers().getLastname(),
                s.getCustomers().getDateofbirth(),
                s.getCustomers().getPhone(), addressDto);
    }

    public static Professor toEntity(ProfessorDto professorDto){
        if(professorDto == null){
            return null;
        }
        Customer c = new Customer();
        c.setDateofbirth(professorDto.getDateofbirth());
        c.setFirstname(professorDto.getFirstname());
        c.setLastname(professorDto.getLastname());
        c.setPhone(professorDto.getPhone());
        c.setAddressid(Mapper.toEntity(professorDto.getAddress()));
        Professor p = new Professor();
        p.setCustomers(c);
        p.setDepartment(p.getDepartment());
        p.setOffice(p.getOffice());
        p.setResearch(p.getResearch());
        return p;
    }

    public static ProfessorDto toDTO(Professor p){
        if(p == null){
            return null;
        }
        AddressDto addressDto = Mapper.toDTO(p.getCustomers().getAddressid());
        return new ProfessorDto(p.getId(),
                p.getDepartment(),
                p.getOffice(),
                p.getResearch(),
                p.getCustomers().getFirstname(),
                p.getCustomers().getLastname(),
                p.getCustomers().getDateofbirth(),
                p.getCustomers().getPhone(), addressDto);
    }

    public static Activity toEntity(ActivityDto activityDto){
        if(activityDto == null)
            return null;
        Activity a= new Activity();
        a.setId(activityDto.getId());
        a.setName(activityDto.getName());
        a.setPrice(activityDto.getPrice());
        return a;
    }

    public static ActivityDto toDTO(Activity activity){
        if (activity == null){
            return null;
        }
        return new ActivityDto(activity.getId(), activity.getName(), activity.getPrice());
    }

    public static Appointment toEntity(AppointmentDto appointmentDto){
        if(appointmentDto == null){
            return null;
        }
        Appointment a = new Appointment();
        a.setActivityid(appointmentDto.getActivityid());
        a.setCustomerid(appointmentDto.getCustomerid());
        a.setStarttime(appointmentDto.getStarttime());
        a.setEndtime(appointmentDto.getEndtime());
        a.setStatus(appointmentDto.getStatus());
        return a;
    }

    public static AppointmentDto toDTO(Appointment appointment){
        if(appointment == null){
            return null;
        }
        AppointmentDto a = new AppointmentDto(
                appointment.getId(),
                appointment.getStarttime(),
                appointment.getEndtime(),
                appointment.getActivityid(),
                appointment.getCustomerid(),
                appointment.getStatus());
        return a;
    }

    public static Discountscheme toEntity(DiscountschemeDto d){
        if (d == null)
            return null;
        Discountscheme ds = new Discountscheme();
        ds.setCustomertype(d.getCustomertype());
        ds.setEnddate(d.getEnddate());
        ds.setStartdate(d.getStartdate());
        ds.setPercentdiscount(d.getPercentdiscount());
        ds.setPricediscount(d.getPricediscount());
        return ds;
    }

    public static DiscountschemeDto toDTO(Discountscheme d){
        if (d == null)
            return null;
        return new DiscountschemeDto(
                d.getId(),
                d.getPricediscount(),
                d.getPercentdiscount(),
                d.getCustomertype(),
                d.getStartdate(),
                d.getEnddate());
    }

    public static HistoricalpriceDto toDTO(Historicalprice hp){
        if (hp == null)
            return null;
        return new HistoricalpriceDto(hp.getId(), hp.getDate(), hp.getPrice(), hp.getActivityid().getId());
    }

    public static OrderDto toDTO(Order o, List<Lineitem> lineitems) {
        OrderDto od = new OrderDto(
                o.getId(),
                o.getDate(),
                o.getTime(),
                o.getDiscountapplied(),
                o.getTotalprice());
        if(lineitems != null && lineitems.size() > 0){
            for(Lineitem ld:lineitems){
                od.addLineItem(Mapper.toDTO(ld));
            }
        }
        return od;
    }

    private static LineitemDto toDTO(Lineitem ld) {
        return new LineitemDto(
                ld.getId(),
                ld.getActivityid().getId(),
                Mapper.toDTO(ld.getAppointmentid()),
                ld.getQuantity(),ld.getOrderid().getId());
    }

}
