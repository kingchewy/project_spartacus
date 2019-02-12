package at.nightfight.controller;

import at.nightfight.model.ShopItem;
import at.nightfight.model.ShopItemArmor;
import at.nightfight.model.ShopItemWeapon;
import at.nightfight.repository.ShopItemArmorRepository;
import at.nightfight.service.ShopItemArmorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources/shopitems/armors")
public class ShopItemArmorController {

    @Autowired
    ShopItemArmorServiceImpl shopItemArmorService;

    @Autowired
    ShopItemArmorRepository shopItemArmorRepository;


    @GetMapping
    public ResponseEntity<List<ShopItemArmor>> getAllShopItemWeapons(){
        List<ShopItemArmor> shopItemArmors = (List<ShopItemArmor>) shopItemArmorRepository.findAll();

        return new ResponseEntity<List<ShopItemArmor>>(shopItemArmors, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShopItemArmor> createNewShopItemArmor(@RequestBody ShopItemArmor shopItemArmor){
        ShopItemArmor createArmor = shopItemArmorService.createShopItemArmor(shopItemArmor);

        return new ResponseEntity<ShopItemArmor>(shopItemArmor, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ShopItem> updateShopItemArmor(@RequestBody ShopItemArmor shopItemArmor){

        Optional<ShopItemArmor> existingArmorOptional = shopItemArmorRepository.findById(shopItemArmor.getId());

        if(existingArmorOptional.isPresent() == false){
            return new ResponseEntity<ShopItem>(HttpStatus.NOT_FOUND);
        }

        ShopItemArmor existingArmor = existingArmorOptional.get();

        ShopItemArmor updatedItem = shopItemArmorService.updateShopItemArmor(shopItemArmor, existingArmor);

        return new ResponseEntity<ShopItem>(updatedItem, HttpStatus.OK);
    }
}
