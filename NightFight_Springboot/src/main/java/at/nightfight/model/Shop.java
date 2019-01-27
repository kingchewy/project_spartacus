package at.nightfight.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

//==== Lombok ====
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="z_shop")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Long discs;

/*    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_inventory_id")
    private ShopInventory shopInventory;*/

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "z_shop_item",
            joinColumns = { @JoinColumn(name = "shop_id")},
            inverseJoinColumns = { @JoinColumn(name = "shopitem_id")}
    )
    private List<ShopItem> shopItems;
}
