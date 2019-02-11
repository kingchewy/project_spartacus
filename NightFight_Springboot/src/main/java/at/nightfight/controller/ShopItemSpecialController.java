package at.nightfight.controller;

import at.nightfight.model.ShopItem;
import at.nightfight.model.ShopItemSpecial;
import at.nightfight.repository.ShopItemSpecialRepository;
import at.nightfight.service.ShopItemSpecialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources/shopitems/specials")
public class ShopItemSpecialController {

    @Autowired
    ShopItemSpecialServiceImpl shopItemSpecialService;

    @Autowired
    ShopItemSpecialRepository shopItemSpecialRepository;


    @GetMapping
    public ResponseEntity<List<ShopItemSpecial>> getAllShopItemWeapons(){
        List<ShopItemSpecial> shopItemSpecials = (List<ShopItemSpecial>) shopItemSpecialRepository.findAll();

        return new ResponseEntity<List<ShopItemSpecial>> (shopItemSpecials, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShopItemSpecial> createNewShopItemArmor(@RequestBody ShopItemSpecial shopItemSpecial){
        ShopItemSpecial createdSpecial = shopItemSpecialService.createShopItemSpecial(shopItemSpecial);

        return new ResponseEntity<ShopItemSpecial>(createdSpecial, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ShopItem> updateShopItemSpecial(@RequestBody ShopItemSpecial shopItemSpecial){

        Optional<ShopItemSpecial> existingSpecialOptional = shopItemSpecialRepository.findById(shopItemSpecial.getId());

        if(existingSpecialOptional.isPresent() == false){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ShopItemSpecial existingSpecial = existingSpecialOptional.get();
        ShopItemSpecial updatedItem = shopItemSpecialService.updateShopItemSpecial(shopItemSpecial, existingSpecial);

        return new ResponseEntity<ShopItem>(updatedItem, HttpStatus.OK);
    }
}
