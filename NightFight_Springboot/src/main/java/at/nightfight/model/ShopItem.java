package at.nightfight.model;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

//==== Lombok ====
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="z_shopitems")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "item_type")
public class ShopItem {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "shop_id")
    private Long id;

    @NonNull
    private String name;

    @Enumerated(EnumType.STRING)
    //@NaturalId
    @Column(length = 60)
    private ItemType itemType;

    @NonNull
    @Column(nullable = false)
    private Long minLvl;

    @NonNull
    private Long price;

    private Long slot;

}
