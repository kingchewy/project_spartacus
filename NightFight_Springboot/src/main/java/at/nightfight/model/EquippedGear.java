package at.nightfight.model;

import at.nightfight.util.serializer.CharacterListSerializer;
import at.nightfight.util.serializer.CharacterSerializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
@Table(name="z_equipped_gear")
public class EquippedGear {

/*    @Id
    @GeneratedValue(generator = "foreigngen")
    @GenericGenerator(
            strategy = "foreign", name = "foreigngen",
            parameters = @Parameter(name = "property", value = "character")
    )
    @Column(name = "character_id")
    private Long characterId;

    @JsonIgnore
    //@JsonSerialize(using = CharacterSerializer.class)
    @OneToOne(mappedBy = "equippedGear")
    private Character character;*/

    @Id
    @Column(name = "character_id")
    private Long characterId;

    @JsonIgnore
    @OneToOne
    @JoinColumn
    @MapsId
    private Character character;

    @OneToOne
    @NonNull
    @JoinColumn(name = "weapon_primary_id")
    private Weapon weaponPrimary;

    @OneToOne
    @NonNull
    @JoinColumn(name = "weapon_secondary_id")
    private Weapon weaponSecondary;

    @OneToOne
    @NonNull
    @JoinColumn(name = "armor_id")
    private Armor armor;

    @OneToOne
    @NonNull
    @JoinColumn(name = "special_item_id")
    private SpecialItem specialItem;

   // private SpecialItem special;

    // METHODS
    @JsonIgnore
    public Long getWeaponPrimaryId(){
        if(weaponPrimary != null){
            return weaponPrimary.getId();
        }
        return null;
    }

    @JsonIgnore
    public Long getWeaponSecondaryId(){
        if(weaponSecondary != null){
            return weaponSecondary.getId();
        }
        return null;
    }
}