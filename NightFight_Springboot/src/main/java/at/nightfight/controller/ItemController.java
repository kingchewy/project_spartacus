package at.nightfight.controller;

import at.nightfight.model.Character;
import at.nightfight.model.Item;
import at.nightfight.model.ItemWeapon;
import at.nightfight.repository.ItemArmorRepository;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;


    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = this.itemRepository.findAll();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

}
