package at.nightfight.service;

import at.nightfight.model.ShopItem;
import at.nightfight.model.ShopItemArmor;

public interface IShopItemArmorService {
    ShopItemArmor createShopItemArmor(ShopItemArmor shopItemArmor);
    ShopItemArmor updateShopItemArmor(ShopItemArmor armorUpdate, ShopItemArmor existingArmor);
}
