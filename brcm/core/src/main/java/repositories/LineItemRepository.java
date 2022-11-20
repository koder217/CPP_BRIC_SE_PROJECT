package repositories;

import entities.Lineitem;

import java.util.List;

public interface LineItemRepository {
    void saveLineItem(Lineitem lineitem);
    void deleteLineItem(int id);
    void updateLineItem(Lineitem lineitem);
    List<Lineitem> getLineItemsForOrderId(int id);
}
