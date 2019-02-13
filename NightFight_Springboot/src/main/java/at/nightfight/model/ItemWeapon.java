package at.nightfight.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

//==== Lombok ====
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="z_weapon")
//@DiscriminatorValue("weapon")
public class ItemWeapon extends Item{

    @NonNull
    private Float damage;

    @NonNull
    private Float accuracy;

    @NonNull
    @Column(name = "critical_damage")
    private Float criticalDamage;

    @Column(name = "two_handed")
    private boolean twoHanded;

    public ItemWeapon(String name, ItemType itemType, Long minLvl, Long price, Float damage, Float accuracy, Float criticalDamage, boolean twoHanded) {
        super(name, itemType, minLvl, price);
        this.damage = damage;
        this.accuracy = accuracy;
        this.criticalDamage = criticalDamage;
        this.twoHanded = twoHanded;
    }
}
