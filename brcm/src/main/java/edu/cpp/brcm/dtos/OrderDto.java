package edu.cpp.brcm.dtos;

import edu.cpp.brcm.entities.Order;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link Order} entity
 */
public class OrderDto implements Serializable {
    private final Integer id;
    private final LocalDate date;
    private final LocalTime time;
    private final Double discountapplied;
    private final Double totalprice;
    private final List<LineitemDto> lineitems;

    public OrderDto(Integer id, LocalDate date, LocalTime time, Double discountapplied, Double totalprice) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.discountapplied = discountapplied;
        this.totalprice = totalprice;
        this.lineitems = new ArrayList<LineitemDto>();
    }
    public void addLineItem(LineitemDto lineitem){
        this.lineitems.add(lineitem);
    }
    public void deleteLineItem(int id){
        LineitemDto objToRemove = null;
        for (LineitemDto lineitem : this.lineitems) {
            if (lineitem.getId() == id) {
                objToRemove = lineitem;
            }
        }
        if(objToRemove != null){
            this.lineitems.remove(objToRemove);
        }
    }
    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Double getDiscountapplied() {
        return discountapplied;
    }
    public Double getTotalprice() {
        return totalprice;
    }
    public List<LineitemDto> getLineitems(){
        return lineitems;
    }
}