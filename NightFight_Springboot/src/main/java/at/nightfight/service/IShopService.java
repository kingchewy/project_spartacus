package at.nightfight.service;

import at.nightfight.model.Character;
import at.nightfight.model.Item;
import at.nightfight.model.Shop;
import at.nightfight.model.dto.ItemDTO;
import at.nightfight.model.dto.ShopTransactionBuyDTO;
import at.nightfight.model.dto.ShopDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IShopService {
    ShopDTO getShopDTO(Shop shop);
    ResponseEntity<Character> buyItems(ShopTransactionBuyDTO shopTransactionBuyDTO, Character character);

    ResponseEntity<Character> sellItems(List<ItemDTO> items, Character character);
}
