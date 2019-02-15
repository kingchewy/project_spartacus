package at.nightfight.model.dto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class ShopTransactionBuyDTO {

    private Long characterId;

    private List<ShopItemDTO> shopItems;


    // CONSTRUCTOR
    public ShopTransactionBuyDTO() {
    }

    public ShopTransactionBuyDTO(Long characterId, List<ShopItemDTO> shopItems) {
        this.characterId = characterId;
        this.shopItems = shopItems;
    }


    // METHODS
    public Iterable<Long> getIterableListOfShopItemIds(){
        Iterable<Long> ids = new ArrayList<>();

        for(ShopItemDTO shopItemDTO: shopItems){
            ((ArrayList<Long>) ids).add(shopItemDTO.getId());
        }
        return ids;
    }

    public Long getQuantityOfShopItemByID(Long id){
        for (ShopItemDTO item : shopItems){
            if(item.getId().equals(id)){
                return item.getQuantity();
            }
        }
        return 0L;
    }
}
