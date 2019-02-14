package at.nightfight.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemArmorDTO extends ItemDTO{

    private Float reducedDamage;
    private Float agility;

    public ItemArmorDTO() {
        setItemType("ARMOR");
    }

    public ItemArmorDTO(Long id, String name, String itemType, Long minLvl, Long price, Long slot, Float reducedDamage, Float agility) {
        super(id, name, itemType, minLvl, price, slot);
        this.reducedDamage = reducedDamage;
        this.agility = agility;
    }
}
