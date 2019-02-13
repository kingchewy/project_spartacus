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
@Table(name="z_special_item")
public class ItemSpecial extends Item{

    private Float damage;

    private Float accuracy;

    @Column(name = "critical_damage")
    private Float criticalDamage;

    @Column(name = "reduced_damage")
    private Float reducedDamage;

    private Float agility;

    public ItemSpecial(@NonNull String name, ItemType itemType, @NonNull Long minLvl, @NonNull Long price, Float damage, Float accuracy, Float criticalDamage, Float reducedDamage, Float agility) {
        super(name, itemType, minLvl, price);
        this.damage = damage;
        this.accuracy = accuracy;
        this.criticalDamage = criticalDamage;
        this.reducedDamage = reducedDamage;
        this.agility = agility;
    }
}
