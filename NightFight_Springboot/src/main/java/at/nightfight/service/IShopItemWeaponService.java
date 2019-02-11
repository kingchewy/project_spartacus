package at.nightfight.service;

import at.nightfight.model.ShopItem;
import at.nightfight.model.ShopItemWeapon;

public interface IShopItemWeaponService {
    ShopItemWeapon createShopItemWeapon(ShopItemWeapon shopItemWeapon);
    ShopItemWeapon updateShopItemWeapon(ShopItemWeapon weaponUpdate, ShopItemWeapon existingWeapon);
}
