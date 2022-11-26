package edu.cpp.brcm.impl;

import edu.cpp.brcm.common.Mapper;
import edu.cpp.brcm.dtos.ActivityDto;
import edu.cpp.brcm.entities.Activity;
import edu.cpp.brcm.entities.Historicalprice;
import edu.cpp.brcm.repositories.ActivityRepository;
import edu.cpp.brcm.repositories.PriceHistoryRepository;
import edu.cpp.brcm.services.ActivityRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
class ActivityRegistrationServiceImpl implements ActivityRegistrationService {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private PriceHistoryRepository priceHistoryRepository;
    @Override
    public List<ActivityDto> getAllActivities() {
        return activityRepository.findAll().stream().map(Mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ActivityDto saveNewActivity(ActivityDto activityDto) {
        Activity a = Mapper.toEntity(activityDto);
        a = activityRepository.save(a);
        Historicalprice hp = new Historicalprice();
        hp.setPrice(activityDto.getPrice());
        hp.setDate(LocalDate.now());
        hp.setActivityid(a);
        priceHistoryRepository.save(hp);
        return Mapper.toDTO(a);
    }

    @Override
    public void deleteActivity(Integer id) {
        activityRepository.deleteById(id);
    }

    @Override
    public void updateActivity(ActivityDto activityDto) {
        Activity a = activityRepository
                .findById(activityDto.getId())
                .orElseThrow(()->new ResourceAccessException("Activity not found with id:"+activityDto.getId()));
        double oldPrice = a.getPrice();
        double newPrice = activityDto.getPrice();
        if(oldPrice != newPrice) {
            a.setPrice(activityDto.getPrice());
            Historicalprice hp = new Historicalprice();
            hp.setPrice(newPrice);
            hp.setDate(LocalDate.now());
            hp.setActivityid(a);
            priceHistoryRepository.save(hp);
        }
        a.setName(activityDto.getName());
        activityRepository.save(a);
    }
}
