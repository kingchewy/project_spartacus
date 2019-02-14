package at.nightfight.util.adapter;

import at.nightfight.model.ShopItemArmor;
import at.nightfight.model.ShopItemSpecial;
import at.nightfight.model.ShopItemWeapon;

public interface IShopItemVisitor<T> {
    T visitShopItemWeapon(ShopItemWeapon shopItemWeapon);
    T visitShopItemArmor(ShopItemArmor shopItemArmor);
    T visitShopItemSpecial(ShopItemSpecial shopItemSpecial);
}
