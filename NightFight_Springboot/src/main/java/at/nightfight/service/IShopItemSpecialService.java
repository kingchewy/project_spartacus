package at.nightfight.service;

import at.nightfight.model.ShopItemSpecial;

public interface IShopItemSpecialService {
    ShopItemSpecial createShopItemSpecial(ShopItemSpecial shopItemSpecial);
    ShopItemSpecial updateShopItemSpecial(ShopItemSpecial specialUpdate, ShopItemSpecial existingSpecial);
}
