package edu.cpp.brcm.impl;

import edu.cpp.brcm.dtos.ActivityDto;
import edu.cpp.brcm.entities.Activity;
import edu.cpp.brcm.entities.Historicalprice;
import edu.cpp.brcm.repositories.ActivityRepository;
import edu.cpp.brcm.repositories.PriceHistoryRepository;
import edu.cpp.brcm.services.ActivityRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;

// Main class
@ExtendWith(MockitoExtension.class)
class ActivityRegistrationServiceTest {
        @Mock
        private ActivityRepository activityRepository;
        @Mock
        private PriceHistoryRepository priceHistoryRepository;
        private ActivityRegistrationService activityRegistrationService;

        @BeforeEach
        void setUp()
        {
            this.activityRegistrationService = new ActivityRegistrationServiceImpl(activityRepository, priceHistoryRepository);
        }

        @Test
        void getAllActivities_CallsActivityRepository_Findall()
        {
            this.activityRegistrationService.getAllActivities();
            verify(activityRepository).findAll();
        }

        @Test
        void saveNewActivity_CallsActivityRepository_Save(){
            ActivityDto dt = new ActivityDto(1, "testActivity", 123.00);
            this.activityRegistrationService.saveNewActivity(dt);
            verify(activityRepository).save(ArgumentMatchers.any(Activity.class));
        }

        @Test
        void saveNewActivity_CallsPriceHistory_Save(){
            ActivityDto dt = new ActivityDto(1, "testActivity", 123.00);
            this.activityRegistrationService.saveNewActivity(dt);
            verify(priceHistoryRepository).save(ArgumentMatchers.any(Historicalprice.class));
        }

        @Test
        void deleteActivity_CallsPriceHistory_FindByActivityId(){
            var m = Mockito.mock(Activity.class);
            Mockito.when(activityRepository.findById(1)).thenReturn(Optional.ofNullable(m));
            this.activityRegistrationService.deleteActivity(1);
            verify(priceHistoryRepository).findByActivityid(ArgumentMatchers.any(Activity.class));
        }

        @Test
        void deleteActivity_CallsActivityRepository_FindById(){
            var m = Mockito.mock(Activity.class);
            Mockito.when(activityRepository.findById(1)).thenReturn(Optional.ofNullable(m));
            this.activityRegistrationService.deleteActivity(1);
            verify(activityRepository).findById(1);
        }

        @Test
        void deleteActivity_CallsActivityRepository_deletebyId(){
            var m = Mockito.mock(Activity.class);
            Mockito.when(activityRepository.findById(1)).thenReturn(Optional.ofNullable(m));
            this.activityRegistrationService.deleteActivity(1);
            verify(activityRepository).deleteById(1);
        }
}