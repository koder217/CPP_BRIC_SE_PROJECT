package dtos;

import entities.Order;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A DTO for the {@link Order} entity
 */
public class OrderDto implements Serializable {
    private final Integer id;
    private final LocalDate date;
    private final LocalTime time;
    private final Double discountapplied;
    private final String totalprice;

    public OrderDto(Integer id, LocalDate date, LocalTime time, Double discountapplied, String totalprice) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.discountapplied = discountapplied;
        this.totalprice = totalprice;
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

    public String getTotalprice() {
        return totalprice;
    }
}