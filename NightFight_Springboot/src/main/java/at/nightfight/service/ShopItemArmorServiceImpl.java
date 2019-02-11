package at.nightfight.service;

import at.nightfight.model.ShopItemArmor;
import at.nightfight.repository.ShopItemArmorRepository;
import at.nightfight.util.mapping.NullPropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopItemArmorServiceImpl implements IShopItemArmorService {

    @Autowired
    ShopItemArmorRepository shopItemArmorRepository;

    @Autowired
    NullPropertyMapper nullPropertyMapper;

    @Override
    public ShopItemArmor createShopItemArmor(ShopItemArmor shopItemArmor) {
        return shopItemArmorRepository.save(shopItemArmor);
    }

    @Override
    public ShopItemArmor updateShopItemArmor(ShopItemArmor armorUpdate, ShopItemArmor existingArmor) {

        // shops for itemArmor will have an auto value of empty array. mapper needs null to work correctly
        //   armorUpdate.setShops(null);

        nullPropertyMapper.copyNonNullProperties(armorUpdate, existingArmor);

        return shopItemArmorRepository.save(existingArmor);
    }
}
