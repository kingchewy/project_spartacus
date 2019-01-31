package at.nightfight.repository;

import at.nightfight.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    public List<Item> findAll();
    //public List<Item> findAllByCharacterId(Long id);
    //List<Item> findByCharacters_id (Long characterId);
    List<Item> findAllByCharacters_CharacterId(Long characterId);

/*    @Query("SELECT i FROM Item i JOIN Character c WHERE c.id = :id")
    public List<Item> getItemsByCharacterId(@Param("id") Long id);*/
}
