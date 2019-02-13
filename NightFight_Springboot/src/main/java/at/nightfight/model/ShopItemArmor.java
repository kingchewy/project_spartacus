package at.nightfight.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
//@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter

//==== JPA ====
@Entity
@Table(name="z_shopitems_armor")
@DiscriminatorValue("ARMOR")
public class ShopItemArmor extends ShopItem implements Serializable {


    //@NonNull
    @Column(name = "reduced_damage")
    private Float reducedDamage;

    //@NonNull
    private Float agility;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopItemArmor)) return false;
        if (!super.equals(o)) return false;
        ShopItemArmor that = (ShopItemArmor) o;
        return Objects.equals(reducedDamage, that.reducedDamage) &&
                Objects.equals(agility, that.agility);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), reducedDamage, agility);
    }

    @Override
    public <T> T accept(IShopItemVisitor<T> visitor) {
        return visitor.visitShopItemArmor(this);
    }

    public ShopItemArmor(Long id, String name, Long minLvl, Long price, Float reducedDamage, Float agility) {
        super(id, name, minLvl, price);
        this.reducedDamage = reducedDamage;
        this.agility = agility;
    }

    @Override
    public String toString() {
        return "ShopItemArmor{" +
                "Id=" + super.getId() +
                ", name=" + super.getName() +
                ", minLvl=" + super.getMinLvl() +
                ", price=" + super.getPrice() +
                ", reducedDamage=" + reducedDamage +
                ", agility=" + agility +
                '}';
    }
}
