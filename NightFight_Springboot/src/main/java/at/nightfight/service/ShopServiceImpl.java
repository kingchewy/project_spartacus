package at.nightfight.service;

import at.nightfight.model.*;
import at.nightfight.model.Character;
import at.nightfight.model.dto.*;
import at.nightfight.model.dto.ShopTransactionSellDTO;
import at.nightfight.repository.*;
import at.nightfight.util.adapter.ShopItemToItemAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

public class ShopServiceImpl implements IShopService {

    @Autowired
    ShopItemWeaponRepository shopItemWeaponRepository;

    @Autowired
    ShopItemRepository shopItemRepository;

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    ShopItemArmorRepository shopItemArmorRepository;

    @Autowired
    ShopItemSpecialRepository shopItemSpecialRepository;


    public ResponseEntity<Character> buyItems(ShopTransactionBuyDTO shopTransactionBuyDTO, Character character){
        List<ShopItem> selectedShopItems = (List) shopItemRepository.findAllById(shopTransactionBuyDTO.getIterableListOfShopItemIds());

        Long itemPriceSum = calculateItemPriceSum(shopTransactionBuyDTO, selectedShopItems);

        if(!character.hasTheMoney(itemPriceSum)){
             return new ResponseEntity("Character has not enough money", HttpStatus.BAD_REQUEST);
        }

        character.pay(itemPriceSum);

        addNewItemsToCharacter(selectedShopItems, character);

        Character updatedCharacter = characterRepository.save(character);

        return new ResponseEntity<Character>(updatedCharacter, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Character> sellItems(List<ItemDTO> itemsForSale, Character character) {

        // If not OWNED item of character -> return response
        for (ItemDTO item : itemsForSale){
            if(!character.isOwnedItem(item.getId())){
                return new ResponseEntity("At least one item not in possesion of specified character", HttpStatus.OK);
            }
        }

        // If equipped, remove from Equipped Items before selling
        for (ItemDTO item : itemsForSale){
            character.sellItem(item.getId());
        }

        Character updatedCharacter = characterRepository.save(character);

        return new ResponseEntity<Character>(updatedCharacter, HttpStatus.OK);
    }

    private void addNewItemsToCharacter(List<ShopItem> selectedShopItems, Character character){
        for (ShopItem shopItem : selectedShopItems){
            Item item = shopItem.accept(new ShopItemToItemAdapter());
            character.addItem(item);
        }
    }

    private Long calculateItemPriceSum(ShopTransactionBuyDTO shopTransactionBuyDTO, List<ShopItem> selectedShopItems){
        Long priceSum = 0L;
        for (ShopItem item : selectedShopItems){
            Long itemPrice = item.getPrice();

            Long itemQuantity = shopTransactionBuyDTO.getQuantityOfShopItemByID(item.getId());

            priceSum += itemPrice * itemQuantity;
        }
        return priceSum;
    }

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

            return new ShopItemWeaponDTO(shopItem.getId(), shopItem.getName(), shopItem.getItemType().name(), shopItem.getMinLvl(),
                    shopItem.getPrice(), ((ShopItemWeapon) shopItem).getDamage(), ((ShopItemWeapon) shopItem).getAccuracy(),
                    ((ShopItemWeapon) shopItem).getCriticalDamage(), ((ShopItemWeapon) shopItem).isTwoHanded());

        } else if (shopItem instanceof ShopItemArmor){
            System.out.println("##########   is ARMOR");

            return new ShopItemArmorDTO(shopItem.getId(), shopItem.getName(), shopItem.getItemType().name(), shopItem.getMinLvl(), shopItem.getPrice(),
                    ((ShopItemArmor) shopItem).getReducedDamage(), ((ShopItemArmor) shopItem).getAgility());

        } else if (shopItem instanceof ShopItemSpecial){
            System.out.println("##########   is SPECIAL");

            return new ShopItemSpecialDTO(shopItem.getId(), shopItem.getName(), shopItem.getItemType().name(), shopItem.getMinLvl(),
                    shopItem.getPrice(), ((ShopItemSpecial) shopItem).getDamage(),((ShopItemSpecial) shopItem).getAccuracy(),
                    ((ShopItemSpecial) shopItem).getCriticalDamage(), ((ShopItemSpecial) shopItem).getReducedDamage(), ((ShopItemSpecial) shopItem).getAgility());
        }

        return null;
    }
}
