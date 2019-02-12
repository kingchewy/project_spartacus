package at.nightfight.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="z_shopitems_special")
@DiscriminatorValue("SPECIAL")
public class ShopItemSpecial extends ShopItem{

    private Float damage;

    private Float accuracy;

    @Column(name = "critical_damage")
    private Float criticalDamage;

    @Column(name = "reduced_damage")
    private Float reducedDamage;

    private Float agility;

    public ShopItemSpecial() {
    }

    public ShopItemSpecial(Long id, String name, Long minLvl, Long price, Float damage, Float accuracy, Float criticalDamage, Float reducedDamage, Float agility) {
        super(id, name, minLvl, price);
        this.damage = damage;
        this.accuracy = accuracy;
        this.criticalDamage = criticalDamage;
        this.reducedDamage = reducedDamage;
        this.agility = agility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopItemSpecial)) return false;
        if (!super.equals(o)) return false;
        ShopItemSpecial that = (ShopItemSpecial) o;
        return Objects.equals(getDamage(), that.getDamage()) &&
                Objects.equals(getAccuracy(), that.getAccuracy()) &&
                Objects.equals(getCriticalDamage(), that.getCriticalDamage()) &&
                Objects.equals(getReducedDamage(), that.getReducedDamage()) &&
                Objects.equals(getAgility(), that.getAgility());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getDamage(), getAccuracy(), getCriticalDamage(), getReducedDamage(), getAgility());
    }
}
