package at.nightfight.model.dto;

import at.nightfight.model.ItemType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ShopItemWeaponDTO extends ShopItemDTO {

    private Float damage;
    private Float accuracy;
    private Float criticalDamage;
    private boolean twoHanded;

    public ShopItemWeaponDTO() {
        setItemType("WEAPON");
    }

    public ShopItemWeaponDTO(Long id, String name, String itemType, Long minLvl, Long price, Float damage, Float accuracy, Float criticalDamage, boolean twoHanded) {
        super(id, name, itemType, minLvl, price);
        this.damage = damage;
        this.accuracy = accuracy;
        this.criticalDamage = criticalDamage;
        this.twoHanded = twoHanded;
    }

    public ShopItemWeaponDTO(Long id, String name, String itemType, Long minLvl, Long price, Long quantity, Float damage, Float accuracy, Float criticalDamage, boolean twoHanded) {
        super(id, name, itemType, minLvl, price, quantity);
        this.damage = damage;
        this.accuracy = accuracy;
        this.criticalDamage = criticalDamage;
        this.twoHanded = twoHanded;
    }
}
