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
@Table(name="t_armor")
@DiscriminatorValue("armor")
public class Armor extends Item {

    @NonNull
    private Float reducedDamage;

    @NonNull
    private Float agility;
}
