package at.nightfight.service;

import at.nightfight.model.ShopItemWeapon;
import at.nightfight.repository.ShopItemWeaponRepository;
import at.nightfight.util.mapping.NullPropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ShopItemWeaponServiceImpl implements IShopItemWeaponService {

    @Autowired
    ShopItemWeaponRepository shopItemWeaponRepository;

    @Autowired
    NullPropertyMapper nullPropertyMapper;

    @Override
    public ShopItemWeapon createShopItemWeapon(ShopItemWeapon shopItemWeapon) {
        return shopItemWeaponRepository.save(shopItemWeapon);
    }

    @Override
    public ShopItemWeapon updateShopItemWeapon(ShopItemWeapon weaponUpdate, ShopItemWeapon existingWeapon) {

        // shops for itemArmor will have an auto value of empty array. mapper needs null to work correctly
        //   weaponUpdate.setShops(null);

        nullPropertyMapper.copyNonNullProperties(weaponUpdate, existingWeapon);

        return shopItemWeaponRepository.save(existingWeapon);
    }
}
