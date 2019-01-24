package at.nightfight.controller;

import at.nightfight.model.Character;
import at.nightfight.model.Inventory;
import at.nightfight.model.Item;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.repository.InventoryRespository;
import at.nightfight.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources/")
public class InventoryController {

    @Autowired
    InventoryRespository inventoryRespository;

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping("/inventorie")
    public ResponseEntity<List<Inventory>> getAllInventories(){
        Iterable<Inventory> inventories = this.inventoryRespository.findAll();
        List<Inventory> list = new ArrayList<>();
        inventories.forEach(list::add);

        return new ResponseEntity<List<Inventory>>(list, HttpStatus.OK);
    }

    @GetMapping("/inventories/all")
    public ResponseEntity<List<Inventory>> getAllInventoriesTest(){
        List<Inventory> list = this.inventoryRespository.findAllTest();

        return new ResponseEntity<List<Inventory>>(list, HttpStatus.OK);
    }

    // NO CREATE INVENTORY RESOURCE -> Automatically created on Character create

/*    @PostMapping("/characters/{id}/inventories")
    public Inventory createInventory(@RequestBody Inventory newInventory, @PathVariable Long id){

        return newInventory;
    }*/



/*    @PostMapping("/inventories")
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory){

        Long id = Long.valueOf(1);
        Optional<Character> character = characterRepository.findById(id);

        Character pureCharachter = new Character();
        if(character.isPresent()){
            pureCharachter = character.get();
        }

        inventory.setCharacter(pureCharachter);

        Inventory newInventory = inventoryRespository.save(inventory);

        return new ResponseEntity<Inventory>(newInventory, HttpStatus.CREATED);
    }*/

    @PostMapping("/items/equipped")
    public ResponseEntity<Inventory> equipNewItem(@RequestBody Inventory inventory){

/*        // Fetch Character and SET to Inventory
        Long id = Long.valueOf(1);
        Optional<Character> characterOptional = characterRepository.findById(id);
        if(characterOptional.isPresent()){
            inventory.setCharacter(characterOptional.get());
        }

        // SET Slot
        Long idSlot = Long.valueOf(5);
        inventory.setSlotNumber(idSlot);


        long idItem = Long.valueOf(27);
        Optional<Item> itemOptional = itemRepository.findById(idItem);
        if(itemOptional.isPresent()){
            Item item = itemOptional.get();
            List<Inventory> list = new ArrayList<>();

            inventory.set
            list.add(inventory);
            item.setInventories(list);
            //itemRepository.save(item);
        }*/

        Inventory newItemSlot = inventoryRespository.save(inventory);

        return new ResponseEntity<Inventory>(newItemSlot, HttpStatus.CREATED);
    }
}
