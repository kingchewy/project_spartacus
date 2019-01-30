package at.nightfight.util.serializer;

import at.nightfight.model.Character;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharacterListSerializer extends StdSerializer<List<Character>> {

    public CharacterListSerializer() {
        this(null);
    }

    public CharacterListSerializer(Class<List<Character>> c) {
        super(c);
    }

    @Override
    public void serialize(List<Character> characters, JsonGenerator gen, SerializerProvider provider) throws IOException {

        List<Long> ids = new ArrayList<>();
        for (Character character : characters){
            ids.add(character.getCharacterId());
        }
        gen.writeObject(ids);
    }
}
