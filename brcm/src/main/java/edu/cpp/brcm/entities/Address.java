package edu.cpp.brcm.entities;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "street")
    private String street;

    @Lob
    @Column(name = "number")
    private String number;

    @Column(name = "zipcode")
    private Integer zipcode;

    @Lob
    @Column(name = "city")
    private String city;

    @Lob
    @Column(name = "state")
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}