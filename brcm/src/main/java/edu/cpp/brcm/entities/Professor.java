package edu.cpp.brcm.entities;

import javax.persistence.*;

@Entity
@Table(name = "professors")
public class Professor {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Customer customer;

    @Lob
    @Column(name = "department", nullable = false)
    private String department;

    @Lob
    @Column(name = "office", nullable = false)
    private String office;

    @Lob
    @Column(name = "research", nullable = false)
    private String research;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

}