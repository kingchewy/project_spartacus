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



}
