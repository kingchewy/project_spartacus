package at.nightfight.model;

public interface IShopItemVisitor<T> {
    T visitShopItemWeapon(ShopItemWeapon shopItemWeapon);
    T visitShopItemArmor(ShopItemArmor shopItemArmor);
    T visitShopItemSpecial(ShopItemSpecial shopItemSpecial);
}
