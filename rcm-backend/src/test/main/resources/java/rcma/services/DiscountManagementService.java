package edu.cpp.brcm.services;

import edu.cpp.brcm.dtos.DiscountschemeDto;

import java.util.List;

public interface DiscountManagementService {
    DiscountschemeDto createDiscountScheme(DiscountschemeDto discountschemeDto);
    List<DiscountschemeDto> getAllDiscountSchemes();
    void deleteDiscountScheme(int id);
    void updateDiscountScheme(DiscountschemeDto discountschemeDto);
}
