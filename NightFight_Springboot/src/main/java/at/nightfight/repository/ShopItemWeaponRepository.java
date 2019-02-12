package at.nightfight.repository;

import at.nightfight.model.ShopItemWeapon;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ShopItemWeaponRepository extends BaseShopItemRepository<ShopItemWeapon> {
}
