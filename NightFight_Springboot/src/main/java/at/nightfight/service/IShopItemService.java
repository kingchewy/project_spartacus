package at.nightfight.service;

import at.nightfight.model.ShopItem;
import at.nightfight.model.ShopItemArmor;
import at.nightfight.model.ShopItemWeapon;

public interface IShopItemService {
    ShopItemWeapon createShopItemWeapon(ShopItemWeapon shopItemWeapon);
    ShopItemArmor createShopItemArmor(ShopItemArmor shopItemArmor);
    ShopItem updateShopItemWeapon(ShopItemWeapon newShopItem);
    ShopItem updateShopItemArmor(ShopItemArmor newShopItem);
}
