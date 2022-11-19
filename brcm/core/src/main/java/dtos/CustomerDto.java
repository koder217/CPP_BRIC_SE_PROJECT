package dtos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link entities.Customer} entity
 */
public class CustomerDto implements Serializable {
    private final Integer id;
    private final String firstname;
    private final String lastname;
    private final LocalDate dateofbirth;
    private final String phone;

    public CustomerDto(Integer id, String firstname, String lastname, LocalDate dateofbirth, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.phone = phone;
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
}