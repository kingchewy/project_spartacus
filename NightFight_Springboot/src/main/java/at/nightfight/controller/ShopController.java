package at.nightfight.controller;

import at.nightfight.model.*;
import at.nightfight.model.Character;
import at.nightfight.model.dto.*;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.repository.ShopItemRepository;
import at.nightfight.repository.ShopRepository;
import at.nightfight.service.ShopServiceImpl;
import at.nightfight.util.mapping.NullPropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/resources")
public class ShopController {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopServiceImpl shopService;

    @Autowired
    private ShopItemRepository shopItemRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private NullPropertyMapper nullPropertyMapper;



    @PostMapping("/shops")
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop){

        Shop newShop = shopRepository.save(shop);

        return new ResponseEntity<Shop>(newShop, HttpStatus.CREATED);
    }


    @GetMapping("/shops/{id}")
    public ResponseEntity<ShopDTO> getShop(@PathVariable("id") Long id){
        Optional<Shop> shopOptional = shopRepository.findById(id);

        if(shopOptional.isPresent()){
            Shop shop = shopOptional.get();
            ShopDTO shopDTO = shopService.getShopDTO(shop);

            return new ResponseEntity<ShopDTO>(shopDTO, HttpStatus.OK);
        }

        return new ResponseEntity (HttpStatus.NOT_FOUND);
    }

    @PutMapping("/shops")
    public ResponseEntity<Shop> updateShopDetails(@RequestBody Shop shopToUpdate){
        Optional<Shop> existingOptional = shopRepository.findById(shopToUpdate.getId());

        if(!existingOptional.isPresent()){
            return new ResponseEntity<Shop>(HttpStatus.NOT_FOUND);
        }

        Shop existingShop = existingOptional.get();

        // shopitems are initialized with empty. mapper needs nullvalues to work correctly
        shopToUpdate.setShopShopitems(null);

        nullPropertyMapper.copyNonNullProperties(shopToUpdate, existingShop);

        Shop updatedShop = shopRepository.save(existingShop);

        return new ResponseEntity<Shop>(updatedShop, HttpStatus.OK);
    }


    @PostMapping("/shops/{id}/shopitems")
    public ResponseEntity<ShopDTO> addShopitemToShop(@PathVariable("id") Long id, @RequestBody  ShopItemAddDTO shopItemAddDTO){

        Optional<Shop> shopOptional = shopRepository.findById(id);
        Optional<ShopItem> shopItemOptional = shopItemRepository.findById(shopItemAddDTO.getShopItemId());

        if(!shopOptional.isPresent() || !shopItemOptional.isPresent()){
            return new ResponseEntity<ShopDTO>(HttpStatus.NOT_FOUND);
        }

        Shop shop = shopOptional.get();
        ShopItem itemToAdd = shopItemOptional.get();

        shop.addShopitem(itemToAdd, shopItemAddDTO.getQuantity());

        Shop updatedShop = shopRepository.save(shop);
        System.out.println("######## UPDATED SHOP -> " + updatedShop);

        ShopDTO shopDTO = shopService.getShopDTO(updatedShop);
        return new ResponseEntity<ShopDTO>(shopDTO, HttpStatus.OK);

    }

    @DeleteMapping("/shops/{shopId}/shopitems/{shopitemId}")
    public ResponseEntity<Shop> removeShopitemFromShop(@PathVariable("shopId") Long shopId, @PathVariable("shopitemId") Long shopitemId){
        Optional<Shop> shopOptional = shopRepository.findById(shopId);
        Optional<ShopItem> shopItemOptional = shopItemRepository.findById(shopitemId);

        if(!shopOptional.isPresent() || !shopItemOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Shop shop = shopOptional.get();
        ShopItem shopItem = shopItemOptional.get();

        shop.removeShopitem(shopItem);

        Shop updatedShop = shopRepository.save(shop);
        return new ResponseEntity<Shop>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/shops/{shopId}/purchase")
    public ResponseEntity buyItems(@PathVariable("shopId") Long shopId, @RequestBody ShopTransactionBuyDTO shopTransactionBuyDTO){

        // 1. FETCH SHOP
        Optional<Shop> shopOptional = shopRepository.findById(shopId);
        if(!shopOptional.isPresent()){
            return new ResponseEntity<>("Shop with ID '"
                    + shopId + "' not found!", HttpStatus.NOT_FOUND);
        }

        // 1.1 SHOP PRESENT -> GET from Optional
        Shop shop = shopOptional.get();

        // 2. FETCH CHARACTER
        Optional<Character> characterOptional = characterRepository.findById(shopTransactionBuyDTO.getCharacterId());
        if(!characterOptional.isPresent()){
            return new ResponseEntity("Character with ID '"
                    + shopTransactionBuyDTO.getCharacterId() + "' not found!", HttpStatus.NOT_FOUND);
        }

        // 2.1 CHARACTER PRESENT -> GET from Optional
        Character character = characterOptional.get();

        // 3. CHECK AVAILABLITY OF ITEMS IN SHOP
        if(!shop.itemsAvailable(shopTransactionBuyDTO.getShopItems())){
            // AT LEAST ONE ITEM NOT AVAILABLE
            return new ResponseEntity("At least one of selected items not available", HttpStatus.NOT_FOUND);
        }

        // 4
        // BUY ITEMS
        return shopService.buyItems(shopTransactionBuyDTO, character);
    }

    @PostMapping("/shops/{shopId}/sale")
    public ResponseEntity sellItems(@PathVariable("shopId") Long shopId, @RequestBody ShopTransactionBuyDTO shopTransactionBuyDTO){



        return new ResponseEntity(HttpStatus.OK);
    }

}
