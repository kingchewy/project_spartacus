package at.nightfight.controller;

import at.nightfight.model.Character;
import at.nightfight.model.Item;
import at.nightfight.model.ItemWeapon;
import at.nightfight.repository.ItemArmorRepository;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemArmorRepository itemArmorRepository;

    @Autowired
    CharacterRepository characterRepository;

    @GetMapping("/characters/{id}/items")
    public ResponseEntity<List<Item>> getCharactersItems(@PathVariable("id") Long id){
        List<Item> items = this.itemRepository.findAllByCharacters_CharacterId(id);

        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = this.itemRepository.findAll();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @PostMapping("/characters/{id}/weapons")
    public ResponseEntity<Character> addWeaponToCharacter(@PathVariable("id") Long id, @RequestBody ItemWeapon itemWeapon){
        Optional<Character> currentCharacterOptional = characterRepository.findById(id);
        if(currentCharacterOptional.isPresent()){
            Character currentCharacter = currentCharacterOptional.get();
            List<Item> ownedItems = currentCharacter.getOwnedItems();
            ownedItems.add(itemWeapon);

            Character savedCharacter = characterRepository.save(currentCharacter);
            return new ResponseEntity<Character>(savedCharacter, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
