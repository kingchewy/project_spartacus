package at.nightfight.controller;

import at.nightfight.model.Character;
import at.nightfight.model.EquippedGear;
import at.nightfight.model.Item;
import at.nightfight.model.ItemWeapon;
import at.nightfight.model.dto.CharacterNewDTO;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.repository.ItemRepository;
import at.nightfight.repository.UserRepository;
import at.nightfight.service.CharacterServiceImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
public class CharacterController {

    @Autowired
    ModelMapper mapper;

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CharacterServiceImpl characterService;


    @GetMapping("/characters")
    public ResponseEntity<List<Character>> getAllCharacters(){
        List<Character> characters = characterRepository.findAll();
        return new ResponseEntity<List<Character>>(characters, HttpStatus.OK);
    }

    @PostMapping("/characters")
    public ResponseEntity<Character> createCharacter(@RequestBody CharacterNewDTO characterNewDTO){

        // MAP to Entity
        Character character = this.convertToEntity(characterNewDTO);

        // SET Default Attributes for new character by race
        character.setNewCharacterAttributes();

        character.setOwnedItems(new ArrayList<>());
        EquippedGear equippedGear = new EquippedGear();
        equippedGear.setCharacterId(character.getCharacterId());
        equippedGear.setCharacter(character);

        character.setEquippedGear(equippedGear);

        // Persist new character and (returns created character)
        Character characterCreated = characterRepository.save(character);
        return new ResponseEntity<Character>(characterCreated, HttpStatus.CREATED);
    }

    @GetMapping("/characters/{id}")
    public Optional<Character> getCharacter(@PathVariable(name = "id") Long id){
        return this.characterRepository.findById(id);
    }

    @GetMapping("/characters/{id}/items")
    public ResponseEntity<List<Item>> getCharactersItems(@PathVariable("id") Long id){
        List<Item> items = this.itemRepository.findAllByCharacters_CharacterId(id);

        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @DeleteMapping("/characters/{characterId}/items/{itemId}")
    public ResponseEntity deleteCharacterItem(@PathVariable("characterId") Long characterId, @PathVariable("itemId") Long itemId){

        return characterService.deleteItem(characterId, itemId);
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

    // HELPER METHODS
    private Character convertToEntity(CharacterNewDTO characterNewDTO){

        if(mapper.getTypeMap(CharacterNewDTO.class, Character.class) == null){
            TypeMap<CharacterNewDTO, Character> typeMap = mapper.createTypeMap(CharacterNewDTO.class, Character.class);
            typeMap.addMappings( mapper -> mapper.skip(Character::setCharacterId));
        }

        return mapper.map(characterNewDTO, Character.class);
    }
}
