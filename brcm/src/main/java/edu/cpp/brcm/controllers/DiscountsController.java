package edu.cpp.brcm.controllers;

import edu.cpp.brcm.dtos.DiscountschemeDto;
import edu.cpp.brcm.services.DiscountManagementService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Discounts", description = "CRUD for discounts")
public class DiscountsController {
    @Autowired
    private DiscountManagementService discountManagementService;
    @GetMapping("/discounts")
    public List<DiscountschemeDto> getAllActivties() {
        return discountManagementService.getAllDiscountSchemes();
    }
    @PutMapping("/discounts/{id}")
    public void putDiscount(@PathVariable(value = "id") int id, @RequestBody DiscountschemeDto DiscountschemeDto){
        discountManagementService.updateDiscountScheme(DiscountschemeDto);
    }
    @DeleteMapping("/discounts/{id}")
    public void deleteDiscount(@PathVariable(value = "id") int id){
        discountManagementService.deleteDiscountScheme(id);
    }

    @PostMapping("/discounts")
    public DiscountschemeDto postDiscount(@Valid @RequestBody DiscountschemeDto DiscountschemeDto){
        return discountManagementService.createDiscountScheme(DiscountschemeDto);
    }
}
