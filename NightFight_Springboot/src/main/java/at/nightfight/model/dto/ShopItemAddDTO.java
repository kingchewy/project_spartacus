package at.nightfight.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ShopItemAddDTO {

    private Long shopItemId;

    private Long quantity;
}
