package at.nightfight.model.dto;

import at.nightfight.model.ShopItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public abstract class ShopItemDTO {

    private Long id;
    private String name;
    private Enum itemType;
    private Long minLvl;
    private Long price;
    private Long quantity;

    public ShopItemDTO() {
    }

    public ShopItemDTO(Long id, String name, Enum itemType, Long minLvl, Long price) {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
        this.minLvl = minLvl;
        this.price = price;
    }

    public ShopItemDTO(Long id, String name, Enum itemType, Long minLvl, Long price, Long quantity) {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
        this.minLvl = minLvl;
        this.price = price;
        this.quantity = quantity;
    }
}
