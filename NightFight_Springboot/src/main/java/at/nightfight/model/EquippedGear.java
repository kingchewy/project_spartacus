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
    private ItemWeapon itemWeaponPrimary;

    @OneToOne
    @NonNull
    @JoinColumn(name = "weapon_secondary_id")
    private ItemWeapon itemWeaponSecondary;

    @OneToOne
    @NonNull
    @JoinColumn(name = "armor_id")
    private ItemArmor itemArmor;

    @OneToOne
    @NonNull
    @JoinColumn(name = "special_item_id")
    private ItemSpecial itemSpecial;


    // METHODS
    @JsonIgnore
    public Long getWeaponPrimaryId(){
        if(itemWeaponPrimary != null){
            return itemWeaponPrimary.getId();
        }
        return null;
    }

    @JsonIgnore
    public Long getWeaponSecondaryId(){
        if(itemWeaponSecondary != null){
            return itemWeaponSecondary.getId();
        }
        return null;
    }
}