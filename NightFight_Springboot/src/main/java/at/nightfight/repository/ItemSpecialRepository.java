package at.nightfight.repository;

import at.nightfight.model.ItemSpecial;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemSpecialRepository extends CrudRepository<ItemSpecial, Long> {
    List<ItemSpecial> findAll();
    List<ItemSpecial> findAllByName(String name);
}
