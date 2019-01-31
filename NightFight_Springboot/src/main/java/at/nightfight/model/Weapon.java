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
public class Weapon extends Item{

    @NonNull
    private Float damage;

    @NonNull
    private Float accuracy;

    @NonNull
    private Float criticalDamage;

    @Column(name = "two_handed")
    private boolean twoHanded;

    @Builder
    public Weapon(Long id, @NonNull String name, ItemType itemType, List<Character> characters, @NonNull Long minLvl, @NonNull Long price, Long slot, @NonNull Float damage, @NonNull Float accuracy, @NonNull Float criticalDamage, boolean twoHanded) {
        super(id, name, itemType, characters, minLvl, price, slot);
        this.damage = damage;
        this.accuracy = accuracy;
        this.criticalDamage = criticalDamage;
        this.twoHanded = twoHanded;
    }


}
