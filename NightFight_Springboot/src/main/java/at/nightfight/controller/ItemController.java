package at.nightfight.controller;

import at.nightfight.model.Item;
import at.nightfight.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/characters/{id}/items")
    public ResponseEntity<List<Item>> getCharactersItems(@PathVariable("id") Long id){
        List<Item> items = this.itemRepository.findAllByCharacterId(id);
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = this.itemRepository.findAll();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }
}
