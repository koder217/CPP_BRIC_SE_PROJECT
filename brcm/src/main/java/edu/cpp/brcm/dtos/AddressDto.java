package edu.cpp.brcm.dtos;

import java.io.Serializable;

/**
 * A DTO for the {@link edu.cpp.brcm.entities.Address} entity
 */
public class AddressDto implements Serializable {
    private final Integer id;
    private final String street;
    private final String number;
    private final Integer zipcode;
    private final String city;
    private final String state;

    public AddressDto(Integer id, String street, String number, Integer zipcode, String city, String state) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}