package at.nightfight.service;

import at.nightfight.model.Character;
import at.nightfight.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    CharacterRepository characterRepository;

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
}
