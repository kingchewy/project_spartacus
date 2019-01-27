package at.nightfight.service;

import at.nightfight.model.OwnedItem;
import at.nightfight.repository.OwnedItemRespository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class OwnedItemServiceImpl implements IOwnedItemService {

    @Autowired
    OwnedItemRespository ownedItemRespository;

    @Override
    public List<OwnedItem> getListOfOwnedItems(Long id) {

        Iterable<OwnedItem> ownedItems = this.ownedItemRespository.findAllByCharacterId(id);
        List<OwnedItem> ownedItemList = new ArrayList<>();
        ownedItems.forEach(ownedItemList::add);

        return ownedItemList;
    }
}
