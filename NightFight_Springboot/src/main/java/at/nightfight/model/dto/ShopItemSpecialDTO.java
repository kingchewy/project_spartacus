package at.nightfight.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopItemSpecialDTO extends ShopItemDTO {

    private Float damage;
    private Float accuracy;
    private Float criticalDamage;
    private Float reducedDamage;
    private Float agility;

    public ShopItemSpecialDTO() {
    }

    public ShopItemSpecialDTO(Long id, String name, Enum itemType, Long minLvl, Long price, Float damage, Float accuracy, Float criticalDamage, Float reducedDamage, Float agility) {
        super(id, name, itemType, minLvl, price);
        this.damage = damage;
        this.accuracy = accuracy;
        this.criticalDamage = criticalDamage;
        this.reducedDamage = reducedDamage;
        this.agility = agility;
    }

    public ShopItemSpecialDTO(Long id, String name, Enum itemType, Long minLvl, Long price, Long quantity, Float damage, Float accuracy, Float criticalDamage, Float reducedDamage, Float agility) {
        super(id, name, itemType, minLvl, price, quantity);
        this.damage = damage;
        this.accuracy = accuracy;
        this.criticalDamage = criticalDamage;
        this.reducedDamage = reducedDamage;
        this.agility = agility;
    }
}
