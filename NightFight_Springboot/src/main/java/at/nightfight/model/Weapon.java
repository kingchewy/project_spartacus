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
@Table(name="t_weapon")
@DiscriminatorValue("weapon")
public class Weapon extends Item{

    @NonNull
    private Float damage;

    @NonNull
    private Float accuracy;

    @NonNull
    private Float criticalDamage;
}
