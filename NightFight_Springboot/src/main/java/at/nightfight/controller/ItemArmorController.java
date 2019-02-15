package at.nightfight.controller;

import at.nightfight.model.ItemArmor;
import at.nightfight.model.ItemType;
import at.nightfight.repository.ItemArmorRepository;
import at.nightfight.util.mapping.NullPropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ItemArmorController {

    @Autowired
    ItemArmorRepository itemArmorRepository;

    @Autowired
    NullPropertyMapper nullPropertyMapper;

    @GetMapping("/armors")
    public ResponseEntity<List<ItemArmor>> getAllArmors(){

        List<ItemArmor> itemArmors = itemArmorRepository.findAll();
        return new ResponseEntity<List<ItemArmor>>(itemArmors, HttpStatus.OK);
    }

    @GetMapping("/armors/{name}")
    public ResponseEntity<List<ItemArmor>> getAllArmorsByName(@PathVariable("name") String name){

        List<ItemArmor> itemArmors = itemArmorRepository.findAllByName(name);
        if(itemArmors.isEmpty()){
            return new ResponseEntity("No ItemArmor with name '" + name + "' found.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<ItemArmor>>(itemArmors, HttpStatus.OK);
    }

    @PutMapping("/armors")
    public ResponseEntity<List<ItemArmor>> updateArmorsByName(@RequestBody ItemArmor itemArmor){
        List<ItemArmor> itemArmors = itemArmorRepository.findAllByName(itemArmor.getName());

        itemArmors.forEach(armorToUpdate -> {
            nullPropertyMapper.copyNonNullProperties(itemArmor, armorToUpdate);
        });

        Iterable<ItemArmor> updatedArmorList = itemArmorRepository.saveAll(itemArmors);

        return new ResponseEntity<List<ItemArmor>>((List<ItemArmor>) updatedArmorList, HttpStatus.OK);
    }

    @PostMapping("/armors")
    public ResponseEntity<ItemArmor> createNewArmor(@RequestBody ItemArmor itemArmor){
        if(!itemArmor.getItemType().equals("ARMOR")){
            return new ResponseEntity("Specified ItemType not an ARMOR!", HttpStatus.BAD_REQUEST);
        }
        ItemArmor createdItemArmor = itemArmorRepository.save(itemArmor);

        return  new ResponseEntity<ItemArmor>(createdItemArmor, HttpStatus.CREATED);
    }

    @DeleteMapping("/armors/{id}")
    public ResponseEntity deleteArmor(@PathVariable("id") Long id){
        itemArmorRepository.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
