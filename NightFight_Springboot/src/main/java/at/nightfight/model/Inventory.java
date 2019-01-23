package at.nightfight.model;

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
@Table(name="t_inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NonNull
    //@OneToOne(fetch = FetchType.LAZY, optional = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

/*    @OneToMany
    @JoinColumn(name = "inventory_id")
    private Set<Item> items;*/

    @NonNull
    private Long slotNumber;


}
