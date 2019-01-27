package at.nightfight.controller;

import at.nightfight.model.Shop;
import at.nightfight.model.ShopItem;
import at.nightfight.repository.ShopItemRepository;
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

    @PostMapping("/shopitems")
    public ResponseEntity<ShopItem> createShopItem(@RequestBody ShopItem shopItem){
        ShopItem createdShopItem = shopItemRepository.save(shopItem);

        return new ResponseEntity<ShopItem>(createdShopItem, HttpStatus.CREATED);
    }

    @GetMapping("/shopitems/{id}")
    public ResponseEntity<ShopItem> getShopsItems(@PathVariable("id") Long id){
        Optional<ShopItem> shopItemOptional = shopItemRepository.findById(id);

        if(shopItemOptional.isPresent()){
            return new ResponseEntity<ShopItem>(shopItemOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity( HttpStatus.NOT_FOUND);
    }

    @GetMapping("/shopitems")
    public ResponseEntity<List<ShopItem>> getAllShopItems(){
        List<ShopItem> shopItemList = (List<ShopItem>) shopItemRepository.findAll();
        return new ResponseEntity<List<ShopItem>>(shopItemList, HttpStatus.OK);
    }
}
