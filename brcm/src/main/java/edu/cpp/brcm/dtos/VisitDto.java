package edu.cpp.brcm.dtos;


import edu.cpp.brcm.enums.CustomerType;

import java.util.List;

public class VisitDto {
    public int customerId;
    public CustomerType customerType;
    public List<LineitemDto> lineItems;
}
