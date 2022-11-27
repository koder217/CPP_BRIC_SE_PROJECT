package edu.cpp.brcm.dtos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link edu.cpp.brcm.entities.Discountscheme} entity
 */
public class DiscountschemeDto implements Serializable {
    private final Integer id;
    private final Double pricediscount;
    private final Double percentdiscount;
    private final String customertype;
    private final LocalDate startdate;
    private final LocalDate enddate;
    public DiscountschemeDto(){
        this.id = 0;
        this.pricediscount = 0.0;
        this.percentdiscount = 0.0;
        this.customertype = "";
        this.startdate = LocalDate.MIN;
        this.enddate = LocalDate.MIN;
    }
    public DiscountschemeDto(Integer id, Double pricediscount, Double percentdiscount, String customertype, LocalDate startdate, LocalDate enddate) {
        this.id = id;
        this.pricediscount = pricediscount;
        this.percentdiscount = percentdiscount;
        this.customertype = customertype;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Integer getId() {
        return id;
    }

    public Double getPricediscount() {
        return pricediscount;
    }

    public Double getPercentdiscount() {
        return percentdiscount;
    }

    public String getCustomertype() {
        return customertype;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }
}