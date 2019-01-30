package at.nightfight.util.serializer;

import at.nightfight.model.Character;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.List;

public class CharacterSerializer extends StdSerializer<Character> {
    public CharacterSerializer() {
        this(null);
    }

    public CharacterSerializer(Class<Character> c) {
        super(c);
    }

    @Override
    public void serialize(Character character, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeObject(character.getCharacterId());
    }

}
