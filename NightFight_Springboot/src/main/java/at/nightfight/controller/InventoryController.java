package at.nightfight.controller;

import at.nightfight.model.Inventory;
import at.nightfight.repository.InventoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/resources/")
public class InventoryController {

    @Autowired
    InventoryRespository inventoryRespository;

    @RequestMapping("/inventorie")
    public ResponseEntity<List<Inventory>> getAllInventories(){
        Iterable<Inventory> inventories = this.inventoryRespository.findAll();
        List<Inventory> list = new ArrayList<>();
        inventories.forEach(list::add);

        return new ResponseEntity<List<Inventory>>(list, HttpStatus.OK);
    }

    @GetMapping("/inventories/all")
    public ResponseEntity<List<Inventory>> getAllInventoriesTest(){
        List<Inventory> list = this.inventoryRespository.findAllTest();

        return new ResponseEntity<List<Inventory>>(list, HttpStatus.OK);
    }

    @PostMapping("/characters/{id}/inventories")
    public Inventory createInventory(@RequestBody Inventory newInventory, @PathVariable Long id){

        return newInventory;
    }
}
