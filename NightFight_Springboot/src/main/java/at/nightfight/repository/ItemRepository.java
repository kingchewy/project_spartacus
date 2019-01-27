package at.nightfight.repository;

import at.nightfight.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    public List<Item> findAll();
    public List<Item> findAllByCharacterId(Long id);
}
