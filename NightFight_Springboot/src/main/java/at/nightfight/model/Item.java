package at.nightfight.model;

import lombok.*;

import javax.persistence.*;

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
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Inventory inventory;*/

    @Column(nullable = false)
    private Long minLvl;


}
