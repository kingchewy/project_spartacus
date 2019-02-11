package at.nightfight.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ShopShopItemId implements Serializable {

    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "shopitem_id")
    private Long shopitemId;


    // C O N S T R U C T O R S
    private ShopShopItemId() {}

    public ShopShopItemId(Long shopId, Long shopitemId) {
        this.shopId = shopId;
        this.shopitemId = shopitemId;
    }

    // G E T T E R  &  S E T T E R
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getShopitemId() {
        return shopitemId;
    }

    public void setShopitemId(Long shopitemId) {
        this.shopitemId = shopitemId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopShopItemId that = (ShopShopItemId) o;
        return Objects.equals(shopId, that.shopId) &&
                Objects.equals(shopitemId, that.shopitemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, shopitemId);
    }
}
