package edu.cpp.brcm.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;

/**
 * A DTO for the {@link edu.cpp.brcm.entities.Activity} entity
 */
public class ActivityDto implements Serializable {
    private final Integer id;
    @NotBlank(message = "Name is mandatory")
    private final String name;
    @Positive(message = "Price must be positive")
    private final Double price;

    public ActivityDto(){
        this.id = 0;
        this.name = null;
        this.price = null;
    }
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