package repositories;

import entities.Historicalprice;

import java.util.List;

public interface PriceHistoryRepository {
    List<Historicalprice> getPriceHistoryForActivity(int activityId);
}
