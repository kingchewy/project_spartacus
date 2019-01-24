package at.nightfight.controller;

import at.nightfight.model.OwnedItems;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.repository.OwnedItemsRespository;
import at.nightfight.repository.ItemRepository;
import at.nightfight.service.OwnedItemsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/resources/")
public class OwnedItemsController {

    @Autowired
    OwnedItemsServiceImpl ownedItemsService;

    @Autowired
    OwnedItemsRespository ownedItemsRespository;

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping("/character/{id}/owneditems")
    public ResponseEntity<List<OwnedItems>> getCharactersOwnedItems(@PathVariable Long id){
        List<OwnedItems> ownedItemsList = this.ownedItemsService.getListOfOwnedItems(id);

        return new ResponseEntity<List<OwnedItems>>(ownedItemsList, HttpStatus.OK);
    }

    @GetMapping("/owneditems")
    public ResponseEntity<List<OwnedItems>> getAllOwnedItems(){
        List<OwnedItems> list = this.ownedItemsRespository.findAllTest();

        return new ResponseEntity<List<OwnedItems>>(list, HttpStatus.OK);
    }

    // NO CREATE INVENTORY RESOURCE -> Automatically created on Character create

/*    @PostMapping("/characters/{id}/inventories")
    public OwnedItems createInventory(@RequestBody OwnedItems newInventory, @PathVariable Long id){

        return newInventory;
    }*/



/*    @PostMapping("/inventories")
    public ResponseEntity<OwnedItems> createInventory(@RequestBody OwnedItems inventory){

        Long id = Long.valueOf(1);
        Optional<Character> character = characterRepository.findById(id);

        Character pureCharachter = new Character();
        if(character.isPresent()){
            pureCharachter = character.get();
        }

        inventory.setCharacter(pureCharachter);

        OwnedItems newInventory = ownedItemsRespository.save(inventory);

        return new ResponseEntity<OwnedItems>(newInventory, HttpStatus.CREATED);
    }*/

    @PutMapping("/items/equipped")
    public ResponseEntity<OwnedItems> equipNewItem(@RequestBody OwnedItems OwnedItems){

/*        // Fetch Character and SET to OwnedItems
        Long id = Long.valueOf(1);
        Optional<Character> characterOptional = characterRepository.findById(id);
        if(characterOptional.isPresent()){
            OwnedItems.setCharacter(characterOptional.get());
        }

        // SET Slot
        Long idSlot = Long.valueOf(5);
        OwnedItems.setSlotNumber(idSlot);


        long idItem = Long.valueOf(27);
        Optional<Item> itemOptional = itemRepository.findById(idItem);
        if(itemOptional.isPresent()){
            Item item = itemOptional.get();
            List<OwnedItems> list = new ArrayList<>();

            OwnedItems.set
            list.add(OwnedItems);
            item.setInventories(list);
            //itemRepository.save(item);
        }*/

        OwnedItems newItemSlot = ownedItemsRespository.save(OwnedItems);

        return new ResponseEntity<OwnedItems>(newItemSlot, HttpStatus.CREATED);
    }
}
