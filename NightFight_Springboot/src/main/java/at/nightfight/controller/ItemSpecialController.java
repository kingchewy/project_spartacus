package at.nightfight.controller;

import at.nightfight.model.ItemSpecial;
import at.nightfight.model.ItemType;
import at.nightfight.repository.ItemSpecialRepository;
import at.nightfight.repository.ItemWeaponRepository;
import at.nightfight.util.mapping.NullPropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources/specials")
public class ItemSpecialController {

    @Autowired
    ItemSpecialRepository itemSpecialRepository;

    @Autowired
    NullPropertyMapper nullPropertyMapper;

    @GetMapping
    public ResponseEntity<List<ItemSpecial>> getAllSpecials(){

        List<ItemSpecial> itemSpecials = itemSpecialRepository.findAll();
        return new ResponseEntity<List<ItemSpecial>>(itemSpecials, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<ItemSpecial>> getAllSpecialsByName(@PathVariable("name") String name){

        List<ItemSpecial> itemSpecials = itemSpecialRepository.findAllByName(name);
        if(itemSpecials.isEmpty()){
            return new ResponseEntity("No ItemSpecial with name '" + name + "' found.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<ItemSpecial>>(itemSpecials, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<List<ItemSpecial>> updateSpecialsByName(@RequestBody ItemSpecial itemSpecial){
        List<ItemSpecial> itemSpecials = itemSpecialRepository.findAllByName(itemSpecial.getName());

        itemSpecials.forEach( specialToUpdate -> {
            nullPropertyMapper.copyNonNullProperties(itemSpecial, specialToUpdate);
        });

        Iterable<ItemSpecial> updatedSpecialList = itemSpecialRepository.saveAll(itemSpecials);

        return new ResponseEntity<List<ItemSpecial>>((List<ItemSpecial>) updatedSpecialList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ItemSpecial> createNewSpecial(@RequestBody ItemSpecial itemSpecial){
        if(!itemSpecial.getItemType().equals("SPECIAL")){
            return new ResponseEntity("Specified ItemType not a SPECIAL!", HttpStatus.BAD_REQUEST);
        }
        ItemSpecial createItemSpecial = itemSpecialRepository.save(itemSpecial);

        return new ResponseEntity<ItemSpecial>(createItemSpecial, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSpecial(@PathVariable("id") Long id){
        itemSpecialRepository.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
