package edu.cpp.brcm.dtos;

import java.io.Serializable;

/**
 * A DTO for the {@link Lineitem} entity
 */
public class LineitemDto implements Serializable {
    private final Integer id;
    private final Integer quantity;

    public LineitemDto(Integer id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }
}