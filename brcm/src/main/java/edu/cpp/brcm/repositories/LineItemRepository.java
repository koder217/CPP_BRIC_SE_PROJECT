package edu.cpp.brcm.repositories;

import edu.cpp.brcm.entities.Lineitem;

import java.util.List;

public interface LineItemRepository {
    void saveLineItem(Lineitem lineitem);
    void deleteLineItem(int id);
    void updateLineItem(Lineitem lineitem);
    List<Lineitem> getLineItemsForOrderId(int id);
}
