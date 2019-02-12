package at.nightfight.controller;

import at.nightfight.model.Shop;
import at.nightfight.model.ShopItem;
import at.nightfight.model.ShopItemArmor;
import at.nightfight.model.ShopItemWeapon;
import at.nightfight.repository.ShopItemRepository;
import at.nightfight.service.ShopItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
public class ShopItemController {

    @Autowired
    ShopItemRepository shopItemRepository;

    @Autowired
    ShopItemServiceImpl shopItemService;


    @GetMapping("/shopitems/{id}")
    public ResponseEntity<ShopItem> getShopsItems(@PathVariable("id") Long id){
        Optional<ShopItem> shopItemOptional = shopItemRepository.findById(id);

        if(shopItemOptional.isPresent()){
            System.out.println("ShopItem -> " + (ShopItemWeapon) shopItemOptional.get());
            return new ResponseEntity<ShopItem>(shopItemOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity( HttpStatus.NOT_FOUND);
    }

    @GetMapping("/shopitems")
    public ResponseEntity<List<ShopItem>> getAllShopItems(){
        List<ShopItem> shopItemList = (List<ShopItem>) shopItemRepository.findAll();
        return new ResponseEntity<List<ShopItem>>(shopItemList, HttpStatus.OK);
    }

    @DeleteMapping("/shopitems/{id}")
    public ResponseEntity<Shop> deleteItem(@PathVariable("id") Long id){
        shopItemRepository.deleteById(id);

        return new ResponseEntity<Shop>(HttpStatus.NO_CONTENT);
    }



}
