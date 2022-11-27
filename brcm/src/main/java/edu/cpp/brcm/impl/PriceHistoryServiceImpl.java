package edu.cpp.brcm.impl;

import edu.cpp.brcm.common.Mapper;
import edu.cpp.brcm.dtos.HistoricalpriceDto;
import edu.cpp.brcm.entities.Activity;
import edu.cpp.brcm.repositories.ActivityRepository;
import edu.cpp.brcm.repositories.PriceHistoryRepository;
import edu.cpp.brcm.services.PriceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceHistoryServiceImpl implements PriceHistoryService {
    @Autowired
    private PriceHistoryRepository priceHistoryRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Override
    public List<HistoricalpriceDto> getHistoricalPriceForActivity(int id) {
        Activity a = activityRepository
                .findById(id)
                .orElseThrow(()->new ResourceAccessException("Activity not found with id:"+id));
        return priceHistoryRepository.findByActivityid(a).stream().map(Mapper::toDTO).collect(Collectors.toList());
    }
}
