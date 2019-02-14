package at.nightfight.service;

import at.nightfight.model.Character;
import at.nightfight.model.Item;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Character> getCharacterListByUserId(Long id) {
        List<Character> characters = this.characterRepository.findAllByUserId(id);
        return characters;
    }

    @Override
    public Character createCharacter(Character character) {
        return this.characterRepository.save(character);
    }

    @Override
    public Optional<Character> getCharacterById(Long id) {
        return characterRepository.findById(id);
    }

    @Override
    public ResponseEntity deleteItem(Long characterId, Long itemId) {
        Optional<Character> characterOptional = characterRepository.findById(characterId);

        if(!characterOptional.isPresent()){
            return new ResponseEntity("Character does not exist!", HttpStatus.BAD_REQUEST);
        }

        Optional<Item> itemOptional = itemRepository.findById(itemId);
        if(!itemOptional.isPresent()){
            return new ResponseEntity("Item does not exist!", HttpStatus.BAD_REQUEST);
        }

        Character character = characterOptional.get();

        if(!character.isOwnedItem(itemId)){
            return new ResponseEntity("Item with ID " + itemId + " does not belong to Character", HttpStatus.BAD_REQUEST);
        }

        character.deleteItem(itemId);
        characterRepository.save(character);
        itemRepository.deleteById(itemId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
