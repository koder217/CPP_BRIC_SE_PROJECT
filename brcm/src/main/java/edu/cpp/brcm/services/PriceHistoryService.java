package edu.cpp.brcm.services;

import edu.cpp.brcm.dtos.HistoricalpriceDto;

import java.util.List;

public interface PriceHistoryService {
    List<HistoricalpriceDto> getHistoricalPriceForActivity(int id);
}
