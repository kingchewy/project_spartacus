package at.nightfight.repository;

import at.nightfight.model.Weapon;
import org.springframework.data.repository.CrudRepository;

public interface WeaponRepository extends CrudRepository<Weapon, Long> {
}
