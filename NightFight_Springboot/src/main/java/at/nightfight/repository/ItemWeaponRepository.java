package at.nightfight.repository;

import at.nightfight.model.ItemWeapon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemWeaponRepository extends CrudRepository<ItemWeapon, Long> {
    List<ItemWeapon> findAll();
    List<ItemWeapon> findAllByName(String name);
}
