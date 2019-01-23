package at.nightfight.repository;

import at.nightfight.model.Inventory;
import at.nightfight.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventoryRespository extends CrudRepository<Inventory, Long> {
    public Iterable<Inventory> findAll();

    // test

    @Query("select i from Inventory as i")
    List<Inventory> findAllTest();
}
