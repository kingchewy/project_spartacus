package at.nightfight.service;

import at.nightfight.model.*;
import at.nightfight.model.dto.*;
import at.nightfight.repository.ShopItemRepository;
import at.nightfight.repository.ShopItemWeaponRepository;
import at.nightfight.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ShopServiceImpl implements IShopService {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ShopItemWeaponRepository shopItemWeaponRepository;

    @Autowired
    ShopItemRepository shopItemRepository;

/*    @Override
    public ResponseEntity<Shop> createNewWeaponForShop(Long shopId, ShopItemWeapon shopItemWeapon) {
        Optional<Shop> shopOptional = shopRepository.findById(shopId);
        if(shopOptional.isPresent()){
            Shop shop = shopOptional.get();

          //  shop.addShopItem(shopItemWeapon);

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

       //     shop.addShopItem(shopItemArmor);

            Shop updatedShop = shopRepository.save(shop);
            return new ResponseEntity<Shop>(updatedShop, HttpStatus.CREATED);
        }

        return new ResponseEntity<Shop> (HttpStatus.BAD_REQUEST);
    }*/

    @Override
    public ShopDTO getShopDTO(Shop shop) {
        List<ShopItemDTO> itemsDTO = getListOfShopItemDTO(shop);

        ShopDTO shopDTO = new ShopDTO(shop.getId(), shop.getName(), shop.getMoney(), shop.getOpeningTime(),
                shop.getClosingTime(), shop.getAddress(), shop.getCity());

        shopDTO.setShopitems(itemsDTO);

        return shopDTO;
    }

    private List<ShopItemDTO> getListOfShopItemDTO(Shop shop){
        List<ShopItem> shopItems = shopItemRepository.findAllByShops_Shop(shop);

        List<ShopItemDTO> items = new ArrayList<>();

        shopItems.forEach( shopItem -> {
            System.out.println("######----####### shopitem --->  " + shopItem + " / CLASS = " + shopItem.getClass());
            ShopItemDTO shopItemDTO = getDTOAccordingItemClass(shopItem);

            Long quantity = shop.getItemQuantity(shopItem.getId());
            shopItemDTO.setQuantity(quantity);
            items.add(shopItemDTO);
        });

        return items;
    }

    private ShopItemDTO getDTOAccordingItemClass(ShopItem shopItem){
        System.out.println("##########   CHECKING INSTANCE TYPE"+ shopItem.getClass() + " / " + shopItem.getClass().isAssignableFrom(ShopItemArmor.class) );

        if(shopItem instanceof ShopItemWeapon){
            System.out.println("##########   is WEAPON");

            return new ShopItemWeaponDTO(shopItem.getId(), shopItem.getName(), shopItem.getItemType(), shopItem.getMinLvl(),
                    shopItem.getPrice(), ((ShopItemWeapon) shopItem).getDamage(), ((ShopItemWeapon) shopItem).getAccuracy(),
                    ((ShopItemWeapon) shopItem).getCriticalDamage(), ((ShopItemWeapon) shopItem).isTwoHanded());

        } else if (shopItem instanceof ShopItemArmor){
            System.out.println("##########   is ARMOR");

            return new ShopItemArmorDTO(shopItem.getId(), shopItem.getName(), shopItem.getItemType(), shopItem.getMinLvl(), shopItem.getPrice(),
                    ((ShopItemArmor) shopItem).getReducedDamage(), ((ShopItemArmor) shopItem).getAgility());

        } else if (shopItem instanceof ShopItemSpecial){
            System.out.println("##########   is SPECIAL");

            return new ShopItemSpecialDTO(shopItem.getId(), shopItem.getName(), shopItem.getItemType(), shopItem.getMinLvl(),
                    shopItem.getPrice(), ((ShopItemSpecial) shopItem).getDamage(),((ShopItemSpecial) shopItem).getAccuracy(),
                    ((ShopItemSpecial) shopItem).getCriticalDamage(), ((ShopItemSpecial) shopItem).getReducedDamage(), ((ShopItemSpecial) shopItem).getAgility());
        }

        return null;
    }
}
