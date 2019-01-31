package at.nightfight.repository;

import at.nightfight.model.Weapon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeaponRepository extends CrudRepository<Weapon, Long> {

    List<Weapon> findAll();
    List<Weapon> findAllByName(String name);
}
