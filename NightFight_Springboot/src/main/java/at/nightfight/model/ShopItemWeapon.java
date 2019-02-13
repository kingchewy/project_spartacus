package at.nightfight.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

//==== Lombok ====
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter

//==== JPA ====
@Entity
@Table(name="z_shopitems_weapon")
@DiscriminatorValue("WEAPON")
public class ShopItemWeapon extends ShopItem{

    //@NonNull
    private Float damage;

    //@NonNull
    private Float accuracy;

    //@NonNull
    @Column(name = "critical_damage")
    private Float criticalDamage;

    //@NonNull
    @Column(name = "two_handed")
    private boolean twoHanded;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopItemWeapon)) return false;
        if (!super.equals(o)) return false;
        ShopItemWeapon weapon = (ShopItemWeapon) o;
        return twoHanded == weapon.twoHanded &&
                Objects.equals(damage, weapon.damage) &&
                Objects.equals(accuracy, weapon.accuracy) &&
                Objects.equals(criticalDamage, weapon.criticalDamage);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), damage, accuracy, criticalDamage, twoHanded);
    }

    @Override
    public <T> T accept(IShopItemVisitor<T> visitor) {
        return visitor.visitShopItemWeapon(this);
    }

    public ShopItemWeapon(Long id, String name, Long minLvl, Long price, Float damage, Float accuracy, Float criticalDamage, boolean twoHanded) {
        super(id, name, minLvl, price);
        this.damage = damage;
        this.accuracy = accuracy;
        this.criticalDamage = criticalDamage;
        this.twoHanded = twoHanded;
    }

    @Override
    public String toString() {
        return "ShopItemWeapon{"  +
                "Id=" + super.getId() +
                ", name=" + super.getName() +
                ", minLvl=" + super.getMinLvl() +
                ", price=" + super.getPrice() +
                ", damage=" + damage +
                ", accuracy=" + accuracy +
                ", criticalDamage=" + criticalDamage +
                ", twoHanded=" + twoHanded +
                '}';
    }
}
