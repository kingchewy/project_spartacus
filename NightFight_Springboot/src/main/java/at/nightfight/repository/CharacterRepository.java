package at.nightfight.repository;

import java.util.List;

import at.nightfight.model.Character;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, Long> {
	List<Character> findAllByName(String name);
}