package edu.cpp.brcm.repositories;

import edu.cpp.brcm.entities.Historicalprice;

import java.util.List;

public interface PriceHistoryRepository {
    List<Historicalprice> getPriceHistoryForActivity(int activityId);
}
