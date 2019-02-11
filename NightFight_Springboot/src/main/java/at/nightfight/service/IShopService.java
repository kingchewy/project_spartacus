package at.nightfight.service;

import at.nightfight.model.Shop;
import at.nightfight.model.ShopItemArmor;
import at.nightfight.model.ShopItemWeapon;
import at.nightfight.model.dto.ShopDTO;
import org.springframework.http.ResponseEntity;

public interface IShopService {
    /*ResponseEntity createNewWeaponForShop(Long shopId, ShopItemWeapon shopItemWeapon);
    ResponseEntity createNewArmorForShop(Long shopId, ShopItemArmor shopItemArmor);*/
    ShopDTO getShopDTO(Shop shop);
}
