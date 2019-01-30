package at.nightfight.service;

import at.nightfight.model.*;
import at.nightfight.model.Character;
import at.nightfight.repository.CharacterRepository;
import at.nightfight.repository.EquippedGearRespository;
import at.nightfight.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class EquippedGearServiceImpl implements IEquippedGearService {

    @Autowired
    EquippedGearRespository equippedGearRespository;

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    ItemRepository itemRepository;


    @Override
    public Optional<EquippedGear> getEquippedGear(Long characterId) {
        return equippedGearRespository.findById(characterId);
    }


    @Override
    public Character setEquippedGear(Character character, EquippedGear gearToEquip) {

        // Requests with missing IDs for Items are handled as Null Values for that items
        if(isValidGearToEquip(character, gearToEquip) == false){
            return null;
        }

        // All requested Inputs are valid -> Equip
        EquippedGear newEquippedGear = new EquippedGear();

        newEquippedGear.setCharacterId(character.getCharacterId());
        newEquippedGear.setCharacter(character);

        // Fetch Items to equip from Repo ( by ID ) && Set Items
        if(gearToEquip.getWeaponPrimary() != null){
            if(gearToEquip.getWeaponPrimary().getId() != null){
                Weapon newWeaponPrimary = (Weapon) itemRepository.findById(gearToEquip.getWeaponPrimary().getId()).get();
                newEquippedGear.setWeaponPrimary(newWeaponPrimary);
            }
        }

        if(gearToEquip.getWeaponSecondary() != null){
            if(gearToEquip.getWeaponSecondary().getId() != null){
                Weapon newWeaponSecondary = (Weapon) itemRepository.findById(gearToEquip.getWeaponSecondary().getId()).get();
                newEquippedGear.setWeaponSecondary(newWeaponSecondary);
            }
        }

        if(gearToEquip.getArmor() != null){
            if(gearToEquip.getArmor().getId() != null){
                Armor newArmor = (Armor) itemRepository.findById(gearToEquip.getArmor().getId()).get();
                newEquippedGear.setArmor(newArmor);
            }
        }

        if(gearToEquip.getSpecialItem() != null){
            if(gearToEquip.getSpecialItem().getId() != null){
                SpecialItem newSpecialItem = (SpecialItem) itemRepository.findById(gearToEquip.getSpecialItem().getId()).get();
                newEquippedGear.setSpecialItem(newSpecialItem);
            }
        }

        equippedGearRespository.save(newEquippedGear);

        return  characterRepository.findById(character.getCharacterId()).get();
    }


    private boolean isValidGearToEquip(Character character, EquippedGear gearToEquip){

        System.out.println("################ CHECK if allOwnedItems #####################");
        if( allOwnedItems(character, gearToEquip) != true){
            return false;
        }

        System.out.println("################ CHECK if isValidNewWeaponCombo #####################");
        if(isValidNewWeaponCombo(gearToEquip) == false){
            return false;
        }
        System.out.println("##### in method after -> isValidNewWeaponCombo method ");
        return true;
    }


    private boolean allOwnedItems(Character character, EquippedGear gearToEquip){
        List<Item> itemsToEquip = new ArrayList<>();

        if(gearToEquip.getWeaponPrimary() != null){
            itemsToEquip.add(gearToEquip.getWeaponPrimary());
        }

        if(gearToEquip.getWeaponSecondary() != null){
            itemsToEquip.add(gearToEquip.getWeaponSecondary());
        }

        if(gearToEquip.getArmor() != null){
            itemsToEquip.add(gearToEquip.getArmor());
        }

        if(gearToEquip.getSpecialItem() != null){
            itemsToEquip.add(gearToEquip.getSpecialItem());
        }

        for(Item item: itemsToEquip){
            if( (item.getId() != null) && (character.isOwnedItem(item) == false) ){
                System.out.println("########## " + item.getName() + " not owned item");
                return false;
            }
        }
        System.out.println("############ passed all ownedItem Validations!!! ############# ");
        return true;
    }


    private boolean isValidNewWeaponCombo(EquippedGear itemsToEquip){

        Weapon weaponPrimaryToEquip = null;
        Weapon weaponSecondaryToEquip = null;

        if(itemsToEquip.getWeaponPrimaryId() != null){
            weaponPrimaryToEquip = (Weapon) itemRepository.findById(itemsToEquip.getWeaponPrimary().getId()).get();
        }

        if(itemsToEquip.getWeaponSecondaryId() != null){
            weaponSecondaryToEquip = (Weapon) itemRepository.findById(itemsToEquip.getWeaponSecondary().getId()).get();
        }

        System.out.println("#######################  null?  WeaponPrimary = " + weaponSecondaryToEquip + " WeaponSecondary = " + weaponSecondaryToEquip);

        // Case: One or both weaponslots empty
        // if at least one slot is empty the comibnation is valid (two-handed + null possible)
        if( weaponPrimaryToEquip == null || weaponSecondaryToEquip == null){
            return true;
        }

        // Case: Both id's are NULL
        // valid, because no weapons will be set for both
        if(weaponPrimaryToEquip.getId() == null && weaponSecondaryToEquip.getId() == null){
            return true;
        }

        // Case: Two-Handed + second weapon
        // if primary to equip is two-handed and there is a secondary to equip || vice versa
        if( ( weaponPrimaryToEquip.isTwoHanded() == true &&  weaponSecondaryToEquip != null ) ||
                ( weaponSecondaryToEquip.isTwoHanded() == true && weaponPrimaryToEquip != null )){
            System.out.println("##### Two-handed + second weapon -> INVALID ");
            return false;
        }

        // primary and secondary is same -> (id)
        if( weaponPrimaryToEquip.getId() == weaponSecondaryToEquip.getId()){
            System.out.println("##### tried to set same weapon for both hands ");
            return false;
        }

        System.out.println("############ passed WeaponCombo Validation!!! ############# ");
        return true;
    }
}
