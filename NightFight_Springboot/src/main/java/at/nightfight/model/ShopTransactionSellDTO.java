package at.nightfight.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ShopTransactionSellDTO {

    private Long characterId;

    private List<Item> items;


    // CONSTRUCTOR
    public ShopTransactionSellDTO() {
    }

    public ShopTransactionSellDTO(Long characterId, List<Item> items) {
        this.characterId = characterId;
        this.items = items;
    }

    // METHODS
}
