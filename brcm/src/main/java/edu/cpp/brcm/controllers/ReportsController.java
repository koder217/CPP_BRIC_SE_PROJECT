package edu.cpp.brcm.controllers;

import edu.cpp.brcm.dtos.RevenueDto;
import edu.cpp.brcm.services.RevenueReportService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Reports", description = "Get Report data")
public class ReportsController {
    @Autowired
    private RevenueReportService revenueReportService;
    @GetMapping("/reports/{customerType}/{startDt}/{endDt}")
    public List<RevenueDto> getReport(@PathVariable(value = "customerType") String customerType, @PathVariable(value = "startDt") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDt, @PathVariable(value = "endDt")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDt) {
        return revenueReportService.getRevenueReport(customerType.toUpperCase(), startDt, endDt);
    }
}
