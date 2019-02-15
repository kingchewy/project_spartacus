package at.nightfight.controller;

import at.nightfight.model.ItemType;
import at.nightfight.model.ItemWeapon;
import at.nightfight.repository.ItemWeaponRepository;
import at.nightfight.util.mapping.NullPropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ItemWeaponController {

    @Autowired
    ItemWeaponRepository itemWeaponRepository;

    @Autowired
    NullPropertyMapper nullPropertyMapper;

    @GetMapping("/weapons")
    public ResponseEntity<List<ItemWeapon>> getAllWeapons(){

        List<ItemWeapon> itemWeapons = itemWeaponRepository.findAll();
        return new ResponseEntity<List<ItemWeapon>> (itemWeapons, HttpStatus.OK);
    }

    @GetMapping("/weapons/{name}")
    public ResponseEntity<List<ItemWeapon>> getAllWeaponsByName(@PathVariable("name") String name){

        List<ItemWeapon> itemWeapons = itemWeaponRepository.findAllByName(name);
        if(itemWeapons.isEmpty()){
            return new ResponseEntity("No ItemWeapon with name '" + name + "' found.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<ItemWeapon>> (itemWeapons, HttpStatus.OK);
    }

    @PutMapping("/weapons")
    public ResponseEntity<List<ItemWeapon>> updateWeaponsByName(@RequestBody ItemWeapon itemWeapon){
        List<ItemWeapon> itemWeapons = itemWeaponRepository.findAllByName(itemWeapon.getName());

        itemWeapons.forEach(weaponToUpdate -> {
            nullPropertyMapper.copyNonNullProperties(itemWeapon, weaponToUpdate);
        });

        Iterable<ItemWeapon> updatedWeaponList = itemWeaponRepository.saveAll(itemWeapons);

        return new ResponseEntity<List<ItemWeapon>>((List<ItemWeapon>) updatedWeaponList, HttpStatus.OK);
    }

    @PostMapping("/weapons")
    public ResponseEntity<ItemWeapon> createNewWeapon(@RequestBody ItemWeapon itemWeapon){
        if(!itemWeapon.getItemType().equals("WEAPON")){
            return new ResponseEntity("Specified ItemType not a WEAPON!", HttpStatus.BAD_REQUEST);
        }
        ItemWeapon createdItemWeapon = itemWeaponRepository.save(itemWeapon);

        return  new ResponseEntity<ItemWeapon>(createdItemWeapon, HttpStatus.CREATED);
    }

    @DeleteMapping("/weapons/{id}")
    public ResponseEntity deleteWeapon(@PathVariable("id") Long id){
        itemWeaponRepository.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
