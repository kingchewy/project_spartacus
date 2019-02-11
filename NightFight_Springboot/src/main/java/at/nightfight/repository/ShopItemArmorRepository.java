package at.nightfight.repository;

import at.nightfight.model.ShopItemArmor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ShopItemArmorRepository extends BaseShopItemRepository<ShopItemArmor> {
}
