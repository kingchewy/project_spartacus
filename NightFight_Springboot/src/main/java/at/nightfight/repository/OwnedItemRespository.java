package at.nightfight.repository;

import at.nightfight.model.OwnedItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnedItemRespository extends CrudRepository<OwnedItem, Long> {
    public Iterable<OwnedItem> findAll();

    // test
    Iterable<OwnedItem> findAllByCharacterId(Long id);

    @Query("select i from OwnedItem as i")
    List<OwnedItem> findAllTest();
}
