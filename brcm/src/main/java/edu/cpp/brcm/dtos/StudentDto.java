package edu.cpp.brcm.dtos;

import edu.cpp.brcm.entities.Student;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Student} entity
 */
public class StudentDto extends CustomerDto implements Serializable {
    private final Integer id;
    private final LocalDate enterdate;
    private final String major;
    private final String minor;
    private final LocalDate graddate;

    public StudentDto(){
        super(0,"","",LocalDate.MIN,"",new AddressDto(0,"","",0,"",""));
        this.id = 0;
        this.enterdate = LocalDate.MIN;
        this.major = "";
        this.minor = "";
        this.graddate = LocalDate.MAX;
    }
    public StudentDto(Integer id, LocalDate enterdate, String major, String minor, LocalDate graddate, CustomerDto customerDto){
        super(customerDto.getId(), customerDto.getFirstname(), customerDto.getLastname(), customerDto.getDateofbirth(), customerDto.getPhone(), customerDto.getAddress());
        this.id = id;
        this.enterdate = enterdate;
        this.major = major;
        this.minor = minor;
        this.graddate = graddate;
    }
    public StudentDto(Integer id, LocalDate enterdate, String major, String minor, LocalDate graddate, String firstname, String lastname, LocalDate dateofbirth, String phone, AddressDto addressDto) {
        super(id, firstname, lastname, dateofbirth, phone, addressDto);
        this.id = id;
        this.enterdate = enterdate;
        this.major = major;
        this.minor = minor;
        this.graddate = graddate;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getEnterdate() {
        return enterdate;
    }

    public String getMajor() {
        return major;
    }

    public String getMinor() {
        return minor;
    }

    public LocalDate getGraddate() {
        return graddate;
    }
}