package at.nightfight.service;

import at.nightfight.model.Character;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ICharacterService {

    List<Character> getCharacterListByUserId(Long id);
    Character createCharacter(Character character);
    Optional<Character> getCharacterById(Long id);

    ResponseEntity deleteItem(Long characterId, Long itemId);
}
