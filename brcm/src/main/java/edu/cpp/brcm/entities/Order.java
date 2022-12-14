package edu.cpp.brcm.entities;

import edu.cpp.brcm.enums.CustomerType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "\"time\"", nullable = false)
    private LocalTime time;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerid", nullable = false)
    private Customer customerid;

    @Column(name = "discountapplied", nullable = false)
    private Double discountapplied;

    @Column(name = "totalprice", nullable = false)
    private Double totalprice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "discountschemeid", nullable = false)
    private Discountscheme discountschemeid;

    @Column(name = "customertype", nullable = false)
    private String customerType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public Double getDiscountapplied() {
        return discountapplied;
    }

    public void setDiscountapplied(Double discountapplied) {
        this.discountapplied = discountapplied;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Discountscheme getDiscountschemeid() {
        return discountschemeid;
    }

    public void setDiscountschemeid(Discountscheme discountschemeid) {
        this.discountschemeid = discountschemeid;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    public String getCustomerType() {
        return this.customerType;
    }
}