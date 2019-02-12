package at.nightfight.util.serializer;

import at.nightfight.model.Shop;
import at.nightfight.model.ShopItem;
import at.nightfight.model.ShopShopItem;
import at.nightfight.repository.ShopItemRepository;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopItemSerializer extends StdSerializer<ShopItem> {
    public ShopItemSerializer() {
        this(null);
    }

    public ShopItemSerializer(Class<ShopItem> s) {
        super(s);
    }

    @Autowired
    ShopItemRepository shopItemRepository;


    @Override
    public void serialize(ShopItem shopItem, JsonGenerator gen, SerializerProvider provider) throws IOException {
        System.out.println("Serializing ShopItem");
        /*List<Long> shopIds = new ArrayList<Long>();

        shopItem.getShops().forEach( shopShopItem -> shopIds.add(shopShopItem.getShop().getId()));

        shopItem.setShops(shopIds);*/



        Long id = 10L;

        ShopItem serializedShopItem;

        //gen.writeObject(10L);
        gen.writeObject(shopItemRepository.findById(shopItem.getId()));
    }
}
