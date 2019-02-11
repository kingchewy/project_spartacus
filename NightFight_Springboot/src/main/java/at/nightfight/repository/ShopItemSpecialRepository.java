package at.nightfight.repository;

import at.nightfight.model.ShopItemSpecial;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ShopItemSpecialRepository extends BaseShopItemRepository<ShopItemSpecial> {
}
