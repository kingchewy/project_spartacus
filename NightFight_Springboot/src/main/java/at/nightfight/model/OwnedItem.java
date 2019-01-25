package at.nightfight.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;


import javax.persistence.*;
import java.util.List;
import java.util.Set;



//==== Lombok ====
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//==== JPA ====
@Entity
@Table(name="t_owned_items")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OwnedItem {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NonNull
    //@OneToOne(fetch = FetchType.LAZY, optional = false)
/*    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_id", nullable = false)*/

    @JsonBackReference
    @JoinColumn(name= "character_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Character character;

/*    @OneToMany
    @JoinColumn(name = "inventory_id")
    private Set<Item> items;*/

    //@JsonBackReference
/*    @JoinColumn(name= "item_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;*/
/**/

/*    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;*/

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", unique = true)
    private Item item;

    @Column(unique = true)
    @NonNull
    private Long slotNumber;


}