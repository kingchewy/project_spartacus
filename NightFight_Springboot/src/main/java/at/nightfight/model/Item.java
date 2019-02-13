package at.nightfight.model;

import at.nightfight.util.serializer.CharacterListSerializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.hibernate.annotations.NaturalId;

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
@Table(name="z_items")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "item_type")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "item_id")
    private Long id;

    @NonNull
    //@Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    //@NaturalId
    @Column(length = 60)
    private ItemType itemType;

/*    @NonNull
    @JsonIgnore
   //@Column(nullable = true)
    private Long characterId;*/

    //@JsonManagedReference
/*    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id"
    )*/
    @JsonIgnore
    //@JsonSerialize(using = CharacterListSerializer.class)
    @ManyToMany(mappedBy = "ownedItems")
    private List<Character> characters;

    @NonNull
    @Column(nullable = false)
    private Long minLvl;

    @NonNull
    private Long price;

    private Long slot;

    public void addCharacter(Character character){
        characters.add(character);
    }

    public Item(@NonNull String name, ItemType itemType, @NonNull Long minLvl, @NonNull Long price) {
        this.name = name;
        this.itemType = itemType;
        this.minLvl = minLvl;
        this.price = price;
    }
}
