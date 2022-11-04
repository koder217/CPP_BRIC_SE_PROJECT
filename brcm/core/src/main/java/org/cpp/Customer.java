package org.cpp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "first_name", nullable = false)
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setId(String firstName) {
        this.firstName = firstName;
    }
}