package at.nightfight.service;

import at.nightfight.model.ShopItemSpecial;
import at.nightfight.repository.ShopItemSpecialRepository;
import at.nightfight.util.mapping.NullPropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopItemSpecialServiceImpl implements IShopItemSpecialService {

    @Autowired
    ShopItemSpecialRepository shopItemSpecialRepository;

    @Autowired
    NullPropertyMapper nullPropertyMapper;

    @Override
    public ShopItemSpecial createShopItemSpecial(ShopItemSpecial shopItemSpecial) {
        return shopItemSpecialRepository.save(shopItemSpecial);
    }

    @Override
    public ShopItemSpecial updateShopItemSpecial(ShopItemSpecial specialUpdate, ShopItemSpecial existingSpecial) {
        nullPropertyMapper.copyNonNullProperties(specialUpdate, existingSpecial);

        return shopItemSpecialRepository.save(existingSpecial);
    }
}
