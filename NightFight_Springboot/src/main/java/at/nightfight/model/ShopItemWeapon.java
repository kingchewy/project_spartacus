package at.nightfight.model;

import lombok.*;

import javax.persistence.*;

//==== Lombok ====
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="z_shopitems_weapon")
//@DiscriminatorValue("weapon")
public class ShopItemWeapon extends ShopItem{

    @NonNull
    private Float damage;

    @NonNull
    private Float accuracy;

    @NonNull
    private Float criticalDamage;
}
