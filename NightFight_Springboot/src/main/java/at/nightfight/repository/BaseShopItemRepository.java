package at.nightfight.repository;

import at.nightfight.model.ShopItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseShopItemRepository<T extends ShopItem> extends CrudRepository<T , Long> {

    //Optional<T> findById(Long id);

    @Query("select i from ShopItem i")
    List<T> findAllCustom();
}
