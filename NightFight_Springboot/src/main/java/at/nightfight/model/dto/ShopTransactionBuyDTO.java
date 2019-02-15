package at.nightfight.model.dto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class ShopTransactionBuyDTO {

    private Long characterId;

    private List<ShopItemDTO> items;


    // CONSTRUCTOR
    public ShopTransactionBuyDTO() {
    }

    public ShopTransactionBuyDTO(Long characterId, List<ShopItemDTO> items) {
        this.characterId = characterId;
        this.items = items;
    }


    // METHODS
    public Iterable<Long> getIterableListOfShopItemIds(){
        Iterable<Long> ids = new ArrayList<>();

        for(ShopItemDTO shopItemDTO: items){
            ((ArrayList<Long>) ids).add(shopItemDTO.getId());
        }
        return ids;
    }

    public Long getQuantityOfShopItemByID(Long id){
        for (ShopItemDTO item : items){
            if(item.getId().equals(id)){
                return item.getQuantity();
            }
        }
        return 0L;
    }
}
