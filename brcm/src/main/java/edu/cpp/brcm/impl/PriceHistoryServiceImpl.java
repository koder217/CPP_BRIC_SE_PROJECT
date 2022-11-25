package edu.cpp.brcm.impl;

import edu.cpp.brcm.common.Mapper;
import edu.cpp.brcm.dtos.HistoricalpriceDto;
import edu.cpp.brcm.repositories.PriceHistoryRepository;
import edu.cpp.brcm.services.PriceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class PriceHistoryServiceImpl implements PriceHistoryService {
    @Autowired
    private PriceHistoryRepository priceHistoryRepository;
    @Override
    public List<HistoricalpriceDto> getHistoricalPriceForActivity(int id) {
        return priceHistoryRepository.findByActivityid(id).stream().map(Mapper::toDTO).collect(Collectors.toList());
    }
}
