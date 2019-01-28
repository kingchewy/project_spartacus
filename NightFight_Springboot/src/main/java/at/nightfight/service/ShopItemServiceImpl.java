package at.nightfight.service;

import at.nightfight.model.ShopItem;
import at.nightfight.model.ShopItemArmor;
import at.nightfight.model.ShopItemWeapon;
import at.nightfight.repository.ShopItemArmorRepository;
import at.nightfight.repository.ShopItemRepository;
import at.nightfight.repository.ShopItemWeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ShopItemServiceImpl implements IShopItemService {

    @Autowired
    ShopItemWeaponRepository shopItemWeaponRepository;

    @Autowired
    ShopItemArmorRepository shopItemArmorRepository;

    @Autowired
    ShopItemRepository shopItemRepository;

    @Override
    public ShopItemWeapon createShopItemWeapon(ShopItemWeapon shopItemWeapon) {
        return shopItemWeaponRepository.save(shopItemWeapon);
    }

    @Override
    public ShopItemArmor createShopItemArmor(ShopItemArmor shopItemArmor) {
        return shopItemArmorRepository.save(shopItemArmor);
    }

    @Override
    public ShopItem updateShopItemWeapon(ShopItemWeapon newShopItem) {
        System.out.println("######## Item sent -> " + newShopItem);
        return shopItemRepository.save(newShopItem);
    }

    @Override
    public ShopItem updateShopItemArmor(ShopItemArmor newShopItem) {
        return shopItemRepository.save(newShopItem);
    }



}
