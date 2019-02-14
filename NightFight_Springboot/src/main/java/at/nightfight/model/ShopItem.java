package at.nightfight.model;

import at.nightfight.util.adapter.IShopItemVisitor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

//==== Lombok ====


//==== JPA ====
@Entity(name = "ShopItem")
@Table(name="z_shopitems")
@NaturalIdCache
@org.hibernate.annotations.Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE
)

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@DiscriminatorColumn(name = "item_type",
    discriminatorType = DiscriminatorType.STRING)
public abstract class ShopItem implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.TABLE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_type", insertable = false, updatable = false)
    private ItemType itemType;

    @Column(nullable = false)
    private Long minLvl;
    
    private Long price;

    @JsonIgnore
    //@JsonSerialize(using = ShopItemShopsSerializer.class)
    @OneToMany(
            mappedBy = "shopitem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ShopShopItem> shops = new ArrayList<>();

    // C O N S T R U C T O R S
    public ShopItem(){ }

    public ShopItem(Long id, String name, Long minLvl, Long price) {
        this.id = id;
        this.name = name;
        this.minLvl = minLvl;
        this.price = price;
    }

    // G E T T E R S   &   S E T T E R S
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Long getMinLvl() {
        return minLvl;
    }

    public void setMinLvl(Long minLvl) {
        this.minLvl = minLvl;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


    // E Q U A L S  &  H A S H
    public boolean isInstanceOf(Class<? extends ShopItem> clazz){
        return clazz.isInstance(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof ShopItem)) return false;

        ShopItem that = (ShopItem) o;

        return getId().equals(that.getId());
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopItem)) return false;
        ShopItem shopItem = (ShopItem) o;
        return Objects.equals(getId(), shopItem.getId()) &&
                Objects.equals(getName(), shopItem.getName()) &&
                Objects.equals(getMinLvl(), shopItem.getMinLvl()) &&
                Objects.equals(getPrice(), shopItem.getPrice());
    }*/

    @Override
    public int hashCode() {

        return getId().hashCode();
    }


    // METHODS
    public abstract <T> T accept(IShopItemVisitor<T> visitor);


    @Override
    public String toString() {
        return "ShopItem{" +
                this.getClass().toString() +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minLvl=" + minLvl +
                ", price=" + price +
                '}';
    }
}
