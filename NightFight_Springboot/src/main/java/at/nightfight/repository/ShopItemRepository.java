package at.nightfight.repository;

import at.nightfight.model.Shop;
import at.nightfight.model.ShopItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional
public interface ShopItemRepository extends BaseShopItemRepository<ShopItem> {
    List<ShopItem> findAllByShops_Shop(Shop shop);
}
