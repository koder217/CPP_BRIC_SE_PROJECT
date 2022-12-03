package edu.cpp.brcm.dtos;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link edu.cpp.brcm.entities.Customer} entity
 */
public class CustomerDto implements Serializable {
    private final Integer id;
    @NotBlank(message = "First name cannot be empty!")
    private final String firstname;
    private final String lastname;
    private final LocalDate dateofbirth;
    private final String phone;

    private final AddressDto address;
    public CustomerDto(Integer id, String firstname, String lastname, LocalDate dateofbirth, String phone, AddressDto address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.phone = phone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public String getPhone() {
        return phone;
    }
    public AddressDto getAddress() {return address;}
}