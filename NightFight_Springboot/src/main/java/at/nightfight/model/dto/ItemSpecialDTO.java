package at.nightfight.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSpecialDTO extends ItemDTO{

    private Float damage;
    private Float accuracy;
    private Float criticalDamage;
    private Float reducedDamage;
    private Float agility;

    public ItemSpecialDTO() {
        setItemType("SPECIAL");
    }

    public ItemSpecialDTO(Long id, String name, String itemType, Long minLvl, Long price, Long slot, Float damage, Float accuracy, Float criticalDamage, Float reducedDamage, Float agility) {
        super(id, name, itemType, minLvl, price, slot);
        this.damage = damage;
        this.accuracy = accuracy;
        this.criticalDamage = criticalDamage;
        this.reducedDamage = reducedDamage;
        this.agility = agility;
    }
}
