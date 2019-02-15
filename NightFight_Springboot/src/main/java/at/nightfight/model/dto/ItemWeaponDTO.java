package at.nightfight.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ItemWeaponDTO extends ItemDTO {

    private Float damage;
    private Float accuracy;
    private Float criticalDamage;
    private boolean twoHanded;

    public ItemWeaponDTO() {
        setItemType("WEAPON");
    }

    public ItemWeaponDTO(Long id, String name, String itemType, Long minLvl, Long price, Long slot, Float damage, Float accuracy, Float criticalDamage, boolean twoHanded) {
        super(id, name, itemType, minLvl, price, slot);
        this.damage = damage;
        this.accuracy = accuracy;
        this.criticalDamage = criticalDamage;
        this.twoHanded = twoHanded;
    }
}
