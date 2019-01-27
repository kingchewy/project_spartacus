package at.nightfight.repository;

import at.nightfight.model.ShopItem;
import org.springframework.data.repository.CrudRepository;

public interface ShopItemRepository extends CrudRepository<ShopItem, Long> {
}
