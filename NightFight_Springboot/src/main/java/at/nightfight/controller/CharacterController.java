package at.nightfight.controller;

import at.nightfight.model.Character;
import at.nightfight.model.EquippedGear;
import at.nightfight.model.dto.CharacterNewDTO;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.repository.UserRepository;
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
    UserRepository userRepository;

/*    @Autowired
    ICharacterNewMapper mapper;*/

    @GetMapping("/characters")
    public ResponseEntity<List<Character>> getAllCharacters(){
        List<Character> characters = characterRepository.findAll();
        return new ResponseEntity<List<Character>>(characters, HttpStatus.OK);
    }


    @GetMapping("/characters/{id}")
    public Optional<Character> getCharacter(@PathVariable(name = "id") Long id){
        return this.characterRepository.findById(id);
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


    // HELPER METHODS
    private Character convertToEntity(CharacterNewDTO characterNewDTO){

        if(mapper.getTypeMap(CharacterNewDTO.class, Character.class) == null){
            TypeMap<CharacterNewDTO, Character> typeMap = mapper.createTypeMap(CharacterNewDTO.class, Character.class);
            typeMap.addMappings( mapper -> mapper.skip(Character::setCharacterId));
        }

        return mapper.map(characterNewDTO, Character.class);
    }
}
