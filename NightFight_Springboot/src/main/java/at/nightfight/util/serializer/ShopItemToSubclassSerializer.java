package at.nightfight.util.serializer;

import at.nightfight.model.ShopItem;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ShopItemToSubclassSerializer extends StdDeserializer<ShopItem> {
    public ShopItemToSubclassSerializer() {
        this(null);
    }


    public ShopItemToSubclassSerializer(Class<ShopItem> s) {
        super(s);
    }

    @Override
    public ShopItem deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        System.out.println("########### Serialize ShopItem. Value = " + p.getCurrentName());
        return null;
    }
}
