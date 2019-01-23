package at.nightfight.controller;

import at.nightfight.model.Character;
import at.nightfight.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;

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

    @PostMapping("/users/{id}/characters")
    public Optional<Character> createCharacter(@PathVariable(name = "id") Long id){
        Optional<Character> characterOptional = this.characterRepository.findById(id);

      /*  if(characterOptional.isPresent()){
            Character character = characterOptional.get();
            return new ResponseEntity<Character>(character, HttpStatus.OK);
        } else*/

        //return new ResponseEntity<Optional<Character>>(characterOptional, HttpStatus.OK);
        return this.characterRepository.findById(id);
    }
}
