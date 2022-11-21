package edu.cpp.brcm.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "discountscheme")
public class Discountscheme {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "pricediscount")
    private Double pricediscount;

    @Column(name = "percentdiscount")
    private Double percentdiscount;

    @Lob
    @Column(name = "customertype")
    private String customertype;

    @Column(name = "startdate")
    private LocalDate startdate;

    @Column(name = "enddate")
    private LocalDate enddate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPricediscount() {
        return pricediscount;
    }

    public void setPricediscount(Double pricediscount) {
        this.pricediscount = pricediscount;
    }

    public Double getPercentdiscount() {
        return percentdiscount;
    }

    public void setPercentdiscount(Double percentdiscount) {
        this.percentdiscount = percentdiscount;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

}