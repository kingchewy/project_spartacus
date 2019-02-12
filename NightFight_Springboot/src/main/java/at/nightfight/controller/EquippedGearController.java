package at.nightfight.controller;

import at.nightfight.model.Character;
import at.nightfight.model.EquippedGear;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.service.EquippedGearServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/resources")
public class EquippedGearController {

    @Autowired
    EquippedGearServiceImpl equippedGearService;

    @Autowired
    CharacterRepository characterRepository;


    @GetMapping("/characters/{id}/equippedgears")
    public ResponseEntity<EquippedGear> getCharactersEquippedGear(@PathVariable("id") Long id){
        Optional<EquippedGear> equippedGear = equippedGearService.getEquippedGear(id);

        if(equippedGear.isPresent() == false){
            return new ResponseEntity<EquippedGear>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<EquippedGear>(equippedGear.get(), HttpStatus.OK);
    }

    @PostMapping("characters/{id}/equippeditems")
    public ResponseEntity<Character> setEquippedItems(@PathVariable("id") Long id, @RequestBody EquippedGear equippedGear){
        equippedGear.getItemWeaponPrimary().getId();
        System.out.println("#################### weapon by id  -> " + equippedGear.getItemWeaponPrimary().getId());

        Optional<Character> characterOptional = characterRepository.findById(id);

        if(!characterOptional.isPresent()){
            System.out.println("##### Character not present ");
            return new ResponseEntity<Character>(HttpStatus.NOT_FOUND);
        }

        Character updatedCharacter = equippedGearService.setEquippedGear(characterOptional.get(), equippedGear);

        if(updatedCharacter == null){
            System.out.println("##### updated Character = NULL ");
            return new ResponseEntity<Character>(HttpStatus.BAD_REQUEST);
        }

        return  new ResponseEntity<Character>(updatedCharacter, HttpStatus.OK);
    }
}
