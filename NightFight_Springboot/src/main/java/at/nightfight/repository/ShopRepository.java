package at.nightfight.repository;

import at.nightfight.model.Shop;
import at.nightfight.model.ShopItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShopRepository extends CrudRepository<Shop, Long> {
}
