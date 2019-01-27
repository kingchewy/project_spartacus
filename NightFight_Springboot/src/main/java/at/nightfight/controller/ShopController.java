package at.nightfight.controller;

import at.nightfight.model.Shop;
import at.nightfight.model.ShopItem;
import at.nightfight.model.ShopItemWeapon;
import at.nightfight.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
public class ShopController {

    @Autowired
    ShopRepository shopRepository;

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

    @PutMapping("/shops/{id}/shopitems")
    public ResponseEntity<Shop> addItem(@RequestBody ShopItemWeapon shopItemWeapon, @PathVariable("id") Long id){
        System.out.println("########" + shopItemWeapon);
        Optional<Shop> shopOptional = shopRepository.findById(id);
        if(shopOptional.isPresent()){
            Shop shop = shopOptional.get();

            List<ShopItem> currentShopItems = shop.getShopItems();
            currentShopItems.add(shopItemWeapon);

            shop.setShopItems(currentShopItems);
            Shop savedShop = shopRepository.save(shop);

            return new ResponseEntity<Shop>(savedShop, HttpStatus.OK);
        }

        return new ResponseEntity("irgendwas passt nicht", HttpStatus.NOT_FOUND);
    }
}
