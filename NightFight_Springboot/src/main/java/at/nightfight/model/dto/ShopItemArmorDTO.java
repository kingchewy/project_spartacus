package at.nightfight.model.dto;

import at.nightfight.model.ItemType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ShopItemArmorDTO extends ShopItemDTO {

    private Float reducedDamage;
    private Float agility;



    public ShopItemArmorDTO() {
        setItemType("ARMOR");
    }

    public ShopItemArmorDTO(Long id, String name, String itemType, Long minLvl, Long price, Float reducedDamage, Float agility) {
        super(id, name, itemType, minLvl, price);
        this.reducedDamage = reducedDamage;
        this.agility = agility;
    }

    public ShopItemArmorDTO(Long id, String name, String itemType, Long minLvl, Long price, Long quantity, Float reducedDamage, Float agility) {
        super(id, name, itemType, minLvl, price, quantity);
        this.reducedDamage = reducedDamage;
        this.agility = agility;
    }
}
