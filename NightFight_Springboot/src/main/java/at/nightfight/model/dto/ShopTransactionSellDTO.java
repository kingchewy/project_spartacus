package at.nightfight.model.dto;

import at.nightfight.model.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ShopTransactionSellDTO {

    private Long characterId;

    private List<ItemDTO> items;

    public ShopTransactionSellDTO() {
    }

    public ShopTransactionSellDTO(Long characterId, List<ItemDTO> items) {
        this.characterId = characterId;
        this.items = items;
    }
}
