package at.nightfight.model.dto;

import at.nightfight.model.ItemType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@ToString
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "itemType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ShopItemWeaponDTO.class, name = "WEAPON"),
        @JsonSubTypes.Type(value = ShopItemArmorDTO.class, name = "ARMOR"),
        @JsonSubTypes.Type(value = ShopItemSpecialDTO.class, name = "SPECIAL")
})
public abstract class ShopItemDTO {

    private Long id;
    private String name;
    private String itemType;
    private Long minLvl;
    private Long price;
    private Long quantity = 1L;

    public ShopItemDTO() {
    }

    public ShopItemDTO(Long id, String name, String itemType, Long minLvl, Long price) {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
        this.minLvl = minLvl;
        this.price = price;
    }

    public ShopItemDTO(Long id, String name, String itemType, Long minLvl, Long price, Long quantity) {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
        this.minLvl = minLvl;
        this.price = price;
        this.quantity = quantity;
    }
}
