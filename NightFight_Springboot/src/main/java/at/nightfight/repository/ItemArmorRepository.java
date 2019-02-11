package at.nightfight.repository;

import at.nightfight.model.ItemArmor;
import at.nightfight.model.ItemWeapon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemArmorRepository extends CrudRepository<ItemArmor, Long> {
    List<ItemArmor> findAll();
    List<ItemArmor> findAllByName(String name);
}
