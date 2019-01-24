package at.nightfight.controller;

import at.nightfight.model.Character;
import at.nightfight.model.User;
import at.nightfight.model.dto.CharacterNewDTO;
import at.nightfight.model.mapper.ICharacterNewMapper;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Destination;
import javax.swing.text.html.Option;
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
        List<Character> characters = (List<Character>) this.characterRepository.findAll();

        return new ResponseEntity<List<Character>>(characters,HttpStatus.OK);
    }

    @GetMapping("/characters/{id}")
    public Optional<Character> getCharacter(@PathVariable(name = "id") Long id){
        Optional<Character> characterOptional = this.characterRepository.findById(id);

      /*  if(characterOptional.isPresent()){
            Character character = characterOptional.get();
            return new ResponseEntity<Character>(character, HttpStatus.OK);
        } else*/

        //return new ResponseEntity<Optional<Character>>(characterOptional, HttpStatus.OK);
        return this.characterRepository.findById(id);
    }

/*    @PostMapping("/users/{id}/characters")
    public ResponseEntity<Character> createCharacter(@PathVariable(name = "id") Long id, @RequestBody Character character){
        Optional<Character> characterOptional = this.characterRepository.findById(id);

        Character newCharacter = this.characterRepository.save(character);
      *//*  if(characterOptional.isPresent()){
            Character character = characterOptional.get();
            return new ResponseEntity<Character>(character, HttpStatus.OK);
        } else*//*

        //return new ResponseEntity<Optional<Character>>(characterOptional, HttpStatus.OK);
        return new ResponseEntity<Character>(newCharacter, HttpStatus.CREATED);
    }*/

/*    @PostMapping("/users/{id}/characters")
    public ResponseEntity<Character> createCharacter(@PathVariable(name = "id") Long id, @RequestBody CharacterNewDTO characterNewDTO){
        Optional<Character> characterOptional = this.characterRepository.findById(id);

        Character characterNew = mapper.characterNewDTOtoCharacter(characterNewDTO);

        Character characterCreated = this.characterRepository.save(characterNew);


        return new ResponseEntity<Character>(characterCreated, HttpStatus.CREATED);
    }*/

    @PostMapping("/characters")
    public ResponseEntity<Character> createCharacter(@RequestBody CharacterNewDTO characterNewDTO){

        Character character = this.convertToEntity(characterNewDTO);
        character.setNewCharacterAttributes();

        Character characterCreated = characterRepository.save(character);

        return new ResponseEntity<Character>(characterCreated, HttpStatus.CREATED);
    }


    private Character convertToEntity(CharacterNewDTO characterNewDTO){

        if(mapper.getTypeMap(CharacterNewDTO.class, Character.class) == null){
            TypeMap<CharacterNewDTO, Character> typeMap = mapper.createTypeMap(CharacterNewDTO.class, Character.class);
            typeMap.addMappings( mapper -> mapper.skip(Character::setId));
        }

        return mapper.map(characterNewDTO, Character.class);
    }
}
