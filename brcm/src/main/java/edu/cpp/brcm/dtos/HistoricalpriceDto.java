package edu.cpp.brcm.dtos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link edu.cpp.brcm.entities.Historicalprice} entity
 */
public class HistoricalpriceDto implements Serializable {
    private final Integer id;
    private final LocalDate date;
    private final Double price;
    private final Integer activityid;
    public HistoricalpriceDto(){
        this.id = 0;
        this.date = LocalDate.MIN;
        this.price = null;
        this.activityid = 0;
    }
    public HistoricalpriceDto(Integer id, LocalDate date, Double price, Integer activityid) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.activityid = activityid;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getActivityid() { return activityid; }
}