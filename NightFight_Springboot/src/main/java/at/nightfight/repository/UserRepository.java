package at.nightfight.repository;

import at.nightfight.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByName(String name);
}