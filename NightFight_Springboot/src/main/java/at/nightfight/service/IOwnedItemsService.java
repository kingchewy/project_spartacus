package at.nightfight.service;

import at.nightfight.model.OwnedItems;

import java.util.List;

public interface IOwnedItemsService {

    List<OwnedItems> getListOfOwnedItems(Long id);
}
