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

    public HistoricalpriceDto(Integer id, LocalDate date, Double price) {
        this.id = id;
        this.date = date;
        this.price = price;
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
}