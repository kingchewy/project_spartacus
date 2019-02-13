package at.nightfight.model;


import at.nightfight.model.dto.ShopItemDTO;
import at.nightfight.util.serializer.ShopShopItemsSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

//==== Lombok ====

//==== JPA ====
@Entity(name = "Shop")
@Table(name="z_shop")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long money;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private String address;

    private String city;

    //@JsonIgnore
    @JsonSerialize(using = ShopShopItemsSerializer.class)
    @OneToMany(
            mappedBy = "shop",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ShopShopItem> shopShopitems = new ArrayList<>();


    // C O N S T R U C T O R S
    public Shop(){}

    public Shop(String name, Long money, LocalTime openingTime, LocalTime closingTime, String address, String city) {
        this.name = name;
        this.money = money;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.address = address;
        this.city = city;
    }


    // G E T T E R  &   S E T T E R
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

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<ShopShopItem> getShopShopitems() {
        return shopShopitems;
    }

    public void setShopShopitems(List<ShopShopItem> shopShopitems) {
        this.shopShopitems = shopShopitems;
    }


    // M E T H O D S
    public void addShopitem(ShopItem shopitem, Long quantity){

        ShopShopItem shopShopItem = new ShopShopItem(this, shopitem, quantity);
        shopShopitems.add(shopShopItem);
        System.out.println("###########  addShopitem");
    }


    public void removeShopitem(ShopItem shopitem){
        for (Iterator<ShopShopItem> iterator = shopShopitems.iterator();
             iterator.hasNext(); ){
            ShopShopItem shopShopItem = iterator.next();

            if(shopShopItem.getShop().equals(this) && shopShopItem.getShopitem().equals(shopitem)){

                System.out.println("###########  ITERATOR");
                iterator.remove();
                shopShopItem.setShop(null);
                shopShopItem.setShopitem(null);
            }
        }
    }


    public Long getItemQuantity(Long shopItemId){

        for(Iterator<ShopShopItem> iterator = shopShopitems.iterator(); iterator.hasNext();){
            ShopShopItem shopShopItem = iterator.next();

            if(shopShopItem.getShopitem().getId() == shopItemId){
                return shopShopItem.getQuantity();
            }
        }
        return null;
    }

    public boolean itemsAvailable(List<ShopItemDTO> selectedItems){
        AtomicBoolean available = new AtomicBoolean(false);

        for(ShopItemDTO item: selectedItems){
            available.set(false);

            // if quantity not specified, set to 1
            if(item.getQuantity() == null || item.getQuantity() == 0 ){
                item.setQuantity(1L);
            }

            for (ShopShopItem shopShopItem : shopShopitems) {
                ShopItem currentShopItem = shopShopItem.getShopitem();

                if (currentShopItem.getId().equals(item.getId()) && shopShopItem.getQuantity() >= item.getQuantity()) {
                    available.set(true);
                    break;
                }
            }

            if(!available.get()){
                // current Item not available in Shop -> check failed
                break;
            }
        }
        return available.get();
    }


    // E Q U A L S  &   H A S H
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop)) return false;
        Shop shop = (Shop) o;
        return //Objects.equals(getId(), shop.getId()) &&
                Objects.equals(getName(), shop.getName()) &&
                Objects.equals(getMoney(), shop.getMoney()) &&
                Objects.equals(getOpeningTime(), shop.getOpeningTime()) &&
                Objects.equals(getClosingTime(), shop.getClosingTime()) &&
                Objects.equals(getAddress(), shop.getAddress()) &&
                Objects.equals(getCity(), shop.getCity());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getMoney(), getOpeningTime(), getClosingTime(), getAddress(), getCity());
    }
}
