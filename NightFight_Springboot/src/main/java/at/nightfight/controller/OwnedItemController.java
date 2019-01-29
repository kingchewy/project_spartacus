package at.nightfight.controller;

import at.nightfight.model.OwnedItem;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.repository.OwnedItemRespository;
import at.nightfight.repository.ItemRepository;
//import at.nightfight.service.OwnedItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources/")
public class OwnedItemController {

   // @Autowired
//    OwnedItemServiceImpl ownedItemsService;

 //   @Autowired
    OwnedItemRespository ownedItemRespository;

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    ItemRepository itemRepository;

  //  @RequestMapping("/character/{id}/owneditems")
 //   public ResponseEntity<List<OwnedItem>> getCharactersOwnedItems(@PathVariable Long id){
//        List<OwnedItem> ownedItemList = this.ownedItemsService.getListOfOwnedItems(id);

  //      return new ResponseEntity<List<OwnedItem>>(ownedItemList, HttpStatus.OK);
   // }

    @GetMapping("/owneditems")
    public ResponseEntity<List<OwnedItem>> getAllOwnedItems(){
        List<OwnedItem> list = this.ownedItemRespository.findAllTest();

        return new ResponseEntity<List<OwnedItem>>(list, HttpStatus.OK);
    }

    @PutMapping("/owneditems")
    public ResponseEntity<List<OwnedItem>> updateOwnedItems(@RequestBody OwnedItem ownedItem){

        // TODO implenent method
        // request body = list of all owned items
        // updates all ownedItems of a user

        // remove all characteritems from table -> set updated list from request

        //this.ownedItemRespository.saveAll(Iterable<OwnedItem> ownedItem);

        return new ResponseEntity<List<OwnedItem>>((List<OwnedItem>) ownedItem, HttpStatus.NO_CONTENT);
    }

    // NO CREATE INVENTORY RESOURCE -> Automatically created on Character create

/*    @PostMapping("/characters/{id}/inventories")
    public OwnedItem createInventory(@RequestBody OwnedItem newInventory, @PathVariable Long id){

        return newInventory;
    }*/



/*    @PostMapping("/inventories")
    public ResponseEntity<OwnedItem> createInventory(@RequestBody OwnedItem inventory){

        Long id = Long.valueOf(1);
        Optional<Character> character = characterRepository.findById(id);

        Character pureCharachter = new Character();
        if(character.isPresent()){
            pureCharachter = character.get();
        }

        inventory.setCharacter(pureCharachter);

        OwnedItem newInventory = ownedItemRespository.save(inventory);

        return new ResponseEntity<OwnedItem>(newInventory, HttpStatus.CREATED);
    }*/

    @PostMapping("/owneditems")
    public ResponseEntity<OwnedItem> addNewOwnedItem(@RequestBody OwnedItem OwnedItem){

/*        // Fetch Character and SET to OwnedItem
        Long id = Long.valueOf(1);
        Optional<Character> characterOptional = characterRepository.findById(id);
        if(characterOptional.isPresent()){
            OwnedItem.setCharacter(characterOptional.get());
        }

        // SET Slot
        Long idSlot = Long.valueOf(5);
        OwnedItem.setSlotNumber(idSlot);


        long idItem = Long.valueOf(27);
        Optional<Item> itemOptional = itemRepository.findById(idItem);
        if(itemOptional.isPresent()){
            Item item = itemOptional.get();
            List<OwnedItem> list = new ArrayList<>();

            OwnedItem.set
            list.add(OwnedItem);
            item.setInventories(list);
            //itemRepository.save(item);
        }*/

        OwnedItem newItemSlot = ownedItemRespository.save(OwnedItem);

        return new ResponseEntity<OwnedItem>(newItemSlot, HttpStatus.CREATED);
    }
}
