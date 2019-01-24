package at.nightfight.service;

import at.nightfight.model.OwnedItems;
import at.nightfight.repository.OwnedItemsRespository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class OwnedItemsServiceImpl implements IOwnedItemsService {

    @Autowired
    OwnedItemsRespository ownedItemsRespository;

    @Override
    public List<OwnedItems> getListOfOwnedItems(Long id) {

        Iterable<OwnedItems> ownedItems = this.ownedItemsRespository.findAllByCharacterId(id);
        List<OwnedItems> ownedItemsList = new ArrayList<>();
        ownedItems.forEach(ownedItemsList::add);

        return ownedItemsList;
    }
}
