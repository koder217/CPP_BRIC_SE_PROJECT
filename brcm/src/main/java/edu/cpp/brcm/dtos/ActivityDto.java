package edu.cpp.brcm.dtos;

import java.io.Serializable;

/**
 * A DTO for the {@link edu.cpp.brcm.entities.Activity} entity
 */
public class ActivityDto implements Serializable {
    private final Integer id;
    private final String name;
    private final Double price;

    public ActivityDto(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}