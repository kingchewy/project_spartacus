package at.nightfight.service;

import at.nightfight.model.Shop;
import at.nightfight.model.ShopItemArmor;
import at.nightfight.model.ShopItemWeapon;
import at.nightfight.repository.ShopItemWeaponRepository;
import at.nightfight.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ShopServiceImpl implements IShopService {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ShopItemWeaponRepository shopItemWeaponRepository;

    @Override
    public ResponseEntity<Shop> createNewWeaponForShop(Long shopId, ShopItemWeapon shopItemWeapon) {
        Optional<Shop> shopOptional = shopRepository.findById(shopId);
        if(shopOptional.isPresent()){
            Shop shop = shopOptional.get();

            shop.addShopItem(shopItemWeapon);

            Shop updatedShop = shopRepository.save(shop);
            return new ResponseEntity<Shop>(updatedShop, HttpStatus.CREATED);
        }

        return new ResponseEntity<Shop> (HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Shop> createNewArmorForShop(Long shopId, ShopItemArmor shopItemArmor) {
        Optional<Shop> shopOptional = shopRepository.findById(shopId);
        if(shopOptional.isPresent()){
            Shop shop = shopOptional.get();

            shop.addShopItem(shopItemArmor);

            Shop updatedShop = shopRepository.save(shop);
            return new ResponseEntity<Shop>(updatedShop, HttpStatus.CREATED);
        }

        return new ResponseEntity<Shop> (HttpStatus.BAD_REQUEST);
    }


}
