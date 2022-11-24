package edu.cpp.brcm.common;

import edu.cpp.brcm.dtos.AddressDto;
import edu.cpp.brcm.dtos.ProfessorDto;
import edu.cpp.brcm.dtos.StudentDto;
import edu.cpp.brcm.entities.Address;
import edu.cpp.brcm.entities.Customer;
import edu.cpp.brcm.entities.Professor;
import edu.cpp.brcm.entities.Student;

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
}
