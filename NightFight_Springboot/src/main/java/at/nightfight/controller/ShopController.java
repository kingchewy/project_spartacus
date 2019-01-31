package at.nightfight.controller;

import at.nightfight.model.Shop;
import at.nightfight.model.ShopItem;
import at.nightfight.model.ShopItemArmor;
import at.nightfight.model.ShopItemWeapon;
import at.nightfight.repository.ShopRepository;
import at.nightfight.service.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/resources")
public class ShopController {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ShopServiceImpl shopService;

    @PostMapping("/shops")
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop){

        Shop newShop = shopRepository.save(shop);

        return new ResponseEntity<Shop>(newShop, HttpStatus.CREATED);
    }


    @GetMapping("/shops/{id}")
    public ResponseEntity<Shop> getShop(@PathVariable("id") Long id){
        Optional<Shop> shop = shopRepository.findById(id);
        if(shop.isPresent()){
            return new ResponseEntity<Shop>(shop.get(), HttpStatus.OK);
        }

        return new ResponseEntity (HttpStatus.NOT_FOUND);
    }


    @PostMapping("/shops/{id}/weapons")
    public ResponseEntity<Shop> createNewWeapon(@PathVariable("id") Long id, @RequestBody ShopItemWeapon shopItemWeapon){

        ResponseEntity response = shopService.createNewWeaponForShop(id, shopItemWeapon);

        return response;
    }


    @PostMapping("/shops/{id}/armors")
    public ResponseEntity<Shop> createNewArmor(@PathVariable("id") Long id, @RequestBody ShopItemArmor shopItemArmor){
        ResponseEntity response = shopService.createNewArmorForShop(id, shopItemArmor);

        return response;
    }


}
