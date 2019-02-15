package at.nightfight.model.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "itemType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ItemWeaponDTO.class, name = "WEAPON"),
        @JsonSubTypes.Type(value = ItemArmorDTO.class, name = "ARMOR"),
        @JsonSubTypes.Type(value = ItemSpecialDTO.class, name = "SPECIAL")
})
public abstract class ItemDTO {

    private Long id;
    private String name;
    private String itemType;
    private Long minLvl;
    private Long price;
    private Long slot;

    public ItemDTO() {
    }

    public ItemDTO(Long id, String name, String itemType, Long minLvl, Long price, Long slot) {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
        this.minLvl = minLvl;
        this.price = price;
        this.slot = slot;
    }
}
