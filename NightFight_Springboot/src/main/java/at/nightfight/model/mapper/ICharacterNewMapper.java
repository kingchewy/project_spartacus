package at.nightfight.model.mapper;

import at.nightfight.model.Character;
import at.nightfight.model.dto.CharacterNewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = UserIdUserEntityMapper.class )
public interface ICharacterNewMapper {


    //CharacterNewDTO characterToCharacterNewDTO (Character entity);

    @Mappings({
            @Mapping(source = "userId", target = "user")
    })
    Character characterNewDTOtoCharacter (CharacterNewDTO dto);


}
