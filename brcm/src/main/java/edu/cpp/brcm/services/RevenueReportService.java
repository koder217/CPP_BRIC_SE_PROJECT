package edu.cpp.brcm.services;

import edu.cpp.brcm.dtos.RevenueDto;

import java.time.LocalDate;
import java.util.List;

public interface RevenueReportService {
    List<RevenueDto> getRevenueReport(String customerType, LocalDate start, LocalDate end);
}
