package at.nightfight.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="z_shopitems_armor")
public class ShopItemArmor extends ShopItem{

    @NonNull
    private Float reducedDamage;

    @NonNull
    private Float agility;
}
