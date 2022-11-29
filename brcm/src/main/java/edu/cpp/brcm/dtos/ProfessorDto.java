package edu.cpp.brcm.dtos;

import edu.cpp.brcm.entities.Professor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Professor} entity
 */
public class ProfessorDto extends CustomerDto implements Serializable {
    private final Integer id;
    private final String department;
    private final String office;
    private final String research;
    public ProfessorDto(){
        super(0,"","",LocalDate.MIN,"",new AddressDto(0,"","",0,"",""));
        this.id = 0;
        this.department = "";
        this.office = "";
        this.research = "";
    }
    public ProfessorDto(Integer id, String department, String office, String research, CustomerDto customerDto){
        super(customerDto.getId(), customerDto.getFirstname(), customerDto.getLastname(), customerDto.getDateofbirth(), customerDto.getPhone(), customerDto.getAddress());
        this.id = id;
        this.department = department;
        this.office = office;
        this.research = research;
    }
    public ProfessorDto(Integer id, String department, String office, String research, String firstname, String lastname, LocalDate dateofbirth, String phone, AddressDto addressDto) {
        super(id, firstname, lastname, dateofbirth, phone, addressDto);
        this.id = id;
        this.department = department;
        this.office = office;
        this.research = research;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getOffice() {
        return office;
    }

    public String getResearch() {
        return research;
    }
}