package at.nightfight.model;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

//==== Lombok ====
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="z_armor")
//@DiscriminatorValue("itemArmor")
public class ItemArmor extends Item {

    @NonNull
    private Float reducedDamage;

    @NonNull
    private Float agility;

    public ItemArmor(@NonNull String name, ItemType itemType, @NonNull Long minLvl, @NonNull Long price, @NonNull Float reducedDamage, @NonNull Float agility) {
        super(name, itemType, minLvl, price);
        this.reducedDamage = reducedDamage;
        this.agility = agility;
    }
}
