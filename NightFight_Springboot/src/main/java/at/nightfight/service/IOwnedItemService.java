package at.nightfight.service;

import at.nightfight.model.OwnedItem;

import java.util.List;

public interface IOwnedItemService {

    List<OwnedItem> getListOfOwnedItems(Long id);
}
