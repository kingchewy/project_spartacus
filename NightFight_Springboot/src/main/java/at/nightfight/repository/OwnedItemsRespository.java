package at.nightfight.repository;

import at.nightfight.model.OwnedItems;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnedItemsRespository extends CrudRepository<OwnedItems, Long> {
    public Iterable<OwnedItems> findAll();

    // test
    Iterable<OwnedItems> findAllByCharacterId(Long id);

    @Query("select i from OwnedItems as i")
    List<OwnedItems> findAllTest();
}
