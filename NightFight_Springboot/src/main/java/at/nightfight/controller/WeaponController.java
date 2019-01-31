package at.nightfight.controller;

import at.nightfight.model.Weapon;
import at.nightfight.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class WeaponController {

    @Autowired
    WeaponRepository weaponRepository;

    @GetMapping("/weapons")
    public ResponseEntity<List<Weapon>> getAllWeapons(){

        List<Weapon> weapons = weaponRepository.findAll();
        return new ResponseEntity<List<Weapon>> (weapons, HttpStatus.OK);
    }

    @GetMapping("/weapons/{name}")
    public ResponseEntity<List<Weapon>> getAllWeaponsByName(@PathVariable("name") String name){

        List<Weapon> weapons = weaponRepository.findAllByName(name);
        return new ResponseEntity<List<Weapon>> (weapons, HttpStatus.OK);
    }

    @PutMapping("/weapons")
    public ResponseEntity<List<Weapon>> updateWeaponsByName(@RequestBody Weapon weapon){
        List<Weapon> weapons = weaponRepository.findAllByName("SuperHammer");

        weapons.forEach( weaponToUpdate -> {
            weaponToUpdate.setAccuracy(45f);
        });

        Iterable<Weapon> updatedWeaponList = weaponRepository.saveAll(weapons);

        return new ResponseEntity<List<Weapon>>((List<Weapon>) updatedWeaponList, HttpStatus.OK);
    }
}
