package at.nightfight.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="z_equipped_gear")
public class EquippedGear {

    @JsonIgnore
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
    private ItemWeapon weaponPrimary;

    @OneToOne
    @NonNull
    @JoinColumn(name = "weapon_secondary_id")
    private ItemWeapon weaponSecondary;

    @OneToOne
    @NonNull
    @JoinColumn(name = "armor_id")
    private ItemArmor armor;

    @OneToOne
    @NonNull
    @JoinColumn(name = "special_item_id")
    private ItemSpecial special;


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