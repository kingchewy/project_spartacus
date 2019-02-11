package at.nightfight.controller;

import at.nightfight.model.ShopItem;
import at.nightfight.model.ShopItemWeapon;
import at.nightfight.repository.ShopItemWeaponRepository;
import at.nightfight.service.ShopItemWeaponServiceImpl;
import at.nightfight.util.mapping.NullPropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
public class ShopItemWeaponController {

    @Autowired
    ShopItemWeaponRepository shopItemWeaponRepository;

    @Autowired
    ShopItemWeaponServiceImpl shopItemWeaponService;


    @GetMapping("shopitems/weapons")
    public ResponseEntity<List<ShopItemWeapon>> getAllShopItemWeapons(){

        List<ShopItemWeapon> shopItemWeapons = (List<ShopItemWeapon>) shopItemWeaponRepository.findAll();

        return new ResponseEntity<List<ShopItemWeapon>>(shopItemWeapons, HttpStatus.OK);
    }

    @PostMapping("/shopitems/weapons")
    public ResponseEntity<ShopItemWeapon> createNewShopItemWeapon(@RequestBody ShopItemWeapon shopItemWeapon){
        ShopItemWeapon createWeapon = shopItemWeaponService.createShopItemWeapon(shopItemWeapon);

        return new ResponseEntity<ShopItemWeapon>(shopItemWeapon, HttpStatus.CREATED);
    }

    @PutMapping("/shopitems/weapons")
    public ResponseEntity<ShopItem> updateShopItemWeapon(@RequestBody ShopItemWeapon shopItemWeapon){

        Optional<ShopItemWeapon> existingWeaponOptional = shopItemWeaponRepository.findById(shopItemWeapon.getId());

        if(existingWeaponOptional.isPresent() == false){
            return new ResponseEntity<ShopItem>(HttpStatus.NOT_FOUND);
        }

        ShopItemWeapon existingWeapon = existingWeaponOptional.get();

        ShopItemWeapon updatedItem = shopItemWeaponService.updateShopItemWeapon(shopItemWeapon, existingWeapon);

        return new ResponseEntity<ShopItem>(updatedItem, HttpStatus.OK);
    }

}
