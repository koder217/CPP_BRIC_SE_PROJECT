package edu.cpp.brcm.controllers;

import edu.cpp.brcm.dtos.HistoricalpriceDto;
import edu.cpp.brcm.services.PriceHistoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "PriceHistory", description = "Get price history data for an activity")
public class PriceHistoryController {
    @Autowired
    private PriceHistoryService priceHistoryService;
    @GetMapping("/pricehistory/{id}")
    public List<HistoricalpriceDto> getPriceHistoryForActivity(@PathVariable(value = "id") int id) {
        return priceHistoryService.getHistoricalPriceForActivity(id);
    }
}
