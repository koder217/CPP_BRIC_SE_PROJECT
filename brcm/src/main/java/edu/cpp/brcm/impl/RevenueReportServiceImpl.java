package edu.cpp.brcm.impl;

import edu.cpp.brcm.dtos.RevenueDto;
import edu.cpp.brcm.repositories.RevenueReportRepository;
import edu.cpp.brcm.services.RevenueReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RevenueReportServiceImpl implements RevenueReportService {
    @Autowired
    private RevenueReportRepository revenueReportRepository;

    @Override
    public List<RevenueDto> getRevenueReport(String customerType, LocalDate start, LocalDate end) {
        var result = revenueReportRepository.getRevenueReport(customerType, start, end);
        return result.stream().map(t->new RevenueDto(Double.parseDouble(t.get("totalRevenue").toString()),t.get("bymonth").toString(),t.get("byyear").toString(), t.get("customerType").toString())).collect(Collectors.toList());
    }
}
