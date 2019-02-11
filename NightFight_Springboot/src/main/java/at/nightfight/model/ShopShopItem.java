package at.nightfight.model;

import at.nightfight.util.serializer.ShopItemSerializer;
import at.nightfight.util.serializer.ShopShopItemsSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

//==== Lombok ====
//@Data

@Entity(name = "ShopShopItem")
@Table(name = "z_shop_shopitem")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ShopShopItem {

    @JsonIgnore
    @EmbeddedId
    private ShopShopItemId shopShopItemId;

   //@JsonSerialize(using = ShopItemSerializer.class)
    //@JsonSerialize(using = ShopItemSerializer.class)
    //@JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("shopitemId")
    private ShopItem shopitem;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("shopId")
    private Shop shop;

    private Long quantity;


    // C O N S T R U C T O R S
    public ShopShopItem() {}

    public ShopShopItem(Shop shop, ShopItem shopitem, Long quantity) {
        this.shopitem = shopitem;
        this.shop = shop;
        System.out.println("###########  create shopShopItemId" + shopitem.getId() + " & " + shop.getId());
        this.shopShopItemId = new ShopShopItemId(shop.getId(), shopitem.getId());
        System.out.println("###########  should not see that line" + this.shopShopItemId);
        this.quantity = quantity;
    }


    // G E T T E R   &   S E T T E R
    public ShopItem getShopitem() {
        return shopitem;
    }

    public void setShopitem(ShopItem shopitem) {
        this.shopitem = shopitem;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }


    // E Q U A L S  & H A S H
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( o == null || getClass() != o.getClass()) return false;

        ShopShopItem that = (ShopShopItem) o;
        return  Objects.equals(shopitem, that.shopitem) &&
                Objects.equals(shop, that.shop) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shopitem, shop, quantity);
    }
}
