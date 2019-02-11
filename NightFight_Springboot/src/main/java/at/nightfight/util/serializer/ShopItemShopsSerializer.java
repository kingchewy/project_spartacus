package at.nightfight.util.serializer;

import at.nightfight.model.ShopItem;
import at.nightfight.model.ShopShopItem;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopItemShopsSerializer extends StdSerializer<List<ShopShopItem>> {
    public ShopItemShopsSerializer() {
        this(null);
    }

    public ShopItemShopsSerializer(Class<List<ShopShopItem>> s) {
        super(s);
    }

    @Override
    public void serialize(List<ShopShopItem> shopShopItems, JsonGenerator gen, SerializerProvider provider) throws IOException {
        List<Long> shopIds = new ArrayList<>();

        for(ShopShopItem shopShopItem: shopShopItems){
            shopIds.add(shopShopItem.getShop().getId());
        }

        gen.writeObject(shopIds);
    }

}
