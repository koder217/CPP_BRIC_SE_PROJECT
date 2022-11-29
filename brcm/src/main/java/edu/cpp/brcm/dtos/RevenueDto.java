package edu.cpp.brcm.dtos;

import javax.persistence.Entity;


public class RevenueDto {
    private double totalRevenue;
    private String bymonth;
    private String byyear;
    private String customerType;

    public RevenueDto(){

    }
    public RevenueDto(double totalRevenue, String bymonth, String byyear, String customerType) {
        this.totalRevenue = totalRevenue;
        this.bymonth = bymonth;
        this.byyear = byyear;
        this.customerType = customerType;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public String getBymonth() {
        return bymonth;
    }

    public void setBymonth(String bymonth) {
        this.bymonth = bymonth;
    }

    public String getByyear() {
        return byyear;
    }

    public void setByyear(String byyear) {
        this.byyear = byyear;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
