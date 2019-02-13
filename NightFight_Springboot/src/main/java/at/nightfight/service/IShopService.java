package at.nightfight.service;

import at.nightfight.model.Character;
import at.nightfight.model.Shop;
import at.nightfight.model.ShopItemArmor;
import at.nightfight.model.ShopItemWeapon;
import at.nightfight.model.dto.BuyShopItemDTO;
import at.nightfight.model.dto.ShopDTO;
import org.springframework.http.ResponseEntity;

public interface IShopService {
    ShopDTO getShopDTO(Shop shop);
    ResponseEntity<Character> buyItems(BuyShopItemDTO buyShopItemDTO, Character character);
}
