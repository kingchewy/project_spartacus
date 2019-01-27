package at.nightfight.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.crypto.spec.IvParameterSpec;
import javax.persistence.*;
import java.util.List;

//==== Lombok ====
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="t_item")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "item_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    @NonNull
    //@Column(nullable = false)
    private String name;

    @NonNull
    @Column(name ="item_type", insertable = false, updatable = false)
    protected String itemType;

    @NonNull
   //@Column(nullable = true)
    private Long characterId;

/*    @ManyToOne
    @JoinColumn(name = "inventory_id", insertable =  false, updatable = false)
    private OwnedItem inventory;*/

/*    @NonNull
    @OneToMany
*//*            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )

    //@JsonManagedReference
    @JoinColumn(name = "item_id")
    //@org.hibernate.annotations.IndexColumn(name = "character_index")*//*
    @JoinTable(
            name = "item_itemsinventory",
            joinColumns = { @JoinColumn(name="item_id", referencedColumnName = "item_id")},
            inverseJoinColumns = { @JoinColumn(name = "inventoryItems_ID", referencedColumnName = "id", unique = true)}
    )
    private List<OwnedItem> inventoryItems;*/

/*    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private List<OwnedItem> inventories;*/

/*    @OneToOne(
            mappedBy = "item", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private OwnedItem inventory;*/

    @NonNull
    @Column(nullable = false)
    private Long minLvl;

    @NonNull
    private Long price;
}
