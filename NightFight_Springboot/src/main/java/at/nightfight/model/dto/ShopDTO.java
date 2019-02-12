package at.nightfight.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ShopDTO {

    private Long id;

    private String name;

    private Long money;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private String address;

    private String city;

    private List<ShopItemDTO> shopitems = new ArrayList<>();

    public ShopDTO(Long id, String name, Long money, LocalTime openingTime, LocalTime closingTime, String address, String city) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.address = address;
        this.city = city;
    }
}
